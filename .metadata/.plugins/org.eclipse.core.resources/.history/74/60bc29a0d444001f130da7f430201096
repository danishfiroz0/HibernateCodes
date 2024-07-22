



package com.pwskills.danish.main;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.pwskill.danish.util.hibernateUtil;
import com.pwskills.danish.bean.InsurancePolicy;

public class EntityQuery_allcolulmns {
	
	public static void main(String[] args) {
		
		Session session = null;
		Query<InsurancePolicy> query = null;
		
		try {
			session = hibernateUtil.getSession();
			
			query = session.createQuery("FROM com.pwskills.danish.bean.InsurancePolicy"); 
			List<InsurancePolicy> resultList = query.getResultList();
			resultList.forEach(policy -> System.out.println(policy)); //printing each Object/Record
			
			
		
		} catch(HibernateException he) {
			he.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			
			if(session != null) {
				hibernateUtil.closeResources(session);
			}
		}
	} 
	
}
