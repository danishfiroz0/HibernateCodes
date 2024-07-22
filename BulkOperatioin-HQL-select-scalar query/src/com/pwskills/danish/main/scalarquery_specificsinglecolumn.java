



package com.pwskills.danish.main;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.pwskill.danish.util.hibernateUtil;

public class scalarquery_specificsinglecolumn {
	
	public static void main(String[] args) {
		
		Session session = null;
		
		
		
		try {
			session = hibernateUtil.getSession();
			
			
			
			Query<String> query4 = session.createQuery("select policyName from com.pwskills.danish.bean.InsurancePolicy where tenure>:max"); //scalar query -specific column query
			query4.setParameter("max", 2);
			List<String> resultList = query4.getResultList();
			resultList.forEach(System.out::println);
			
			
			
		
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
