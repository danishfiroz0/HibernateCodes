package com.pwskills.danish.main;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pwskill.danish.util.hibernateUtil;
import com.pwskills.danish.bean.Student;

public class MainApp {
	
	public static void main(String[] args) {
		
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		Integer pk= null;    // initialized.--- if we do not initialize, then "might have not 												been initialized problem" because its a local 													variable.
		
		try {
			session = hibernateUtil.getSession();
			if(session != null) {
				transaction =  session.beginTransaction();
			}
			
			
			if(transaction != null) {
				Student std = new Student();
				std.setSaddress("Rasra");
				std.setSage(19);
				std.setSname("tendulkar");
				
				//internally hibernate will execute the insert sql query.
				pk= (Integer)session.save(std);
				flag = true;
			}
			
		
		} catch(HibernateException he) {// copy paste
			he.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(flag) {
				transaction.commit();
				System.out.println("Object saved to database with primary key Id: " + pk);
			} else {
				transaction.rollback();
			}
				
			if(session != null) {
				hibernateUtil.closeResources(session);
			}
		}
	} 
	
}
