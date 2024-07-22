



package com.pwskills.danish.main;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.pwskill.danish.util.hibernateUtil;
import com.pwskills.danish.bean.InsurancePolicy;

public class EntityQuery_allcolulmns {
	
	public static void main(String[] args) {
		
		Session session = null;
		Query<InsurancePolicy> query = null;
		int count = 0;
		boolean flag = false;
		Transaction transaction = null;
		
		try {
			session = hibernateUtil.getSession();
			transaction = session.beginTransaction();
			
			query = session.createQuery("update com.pwskills.danish.bean.InsurancePolicy set tenure=tenure+:addyears where policyName like :initialletters");   //What this line does?  --> create a Query instance that helps you perform retrival, updation, deletion
			query.setParameter("addyears", 5);
			query.setParameter("initialletters", "H%");
			
			count = query.executeUpdate();
			flag=true;
			
		
		} catch(HibernateException he) {
			he.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(flag) {
				transaction.commit();
				System.out.println("record updated = " + count);
				if(session != null) {
					hibernateUtil.closeResources(session);
				}
			}
			else {
				transaction.rollback();
				System.out.println("record updated = " + count);
			}
		}
	} 
	
}
