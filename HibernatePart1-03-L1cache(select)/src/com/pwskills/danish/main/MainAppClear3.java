package com.pwskills.danish.main;


import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.pwskill.danish.util.hibernateUtil;
import com.pwskills.danish.bean.Student;

public class MainAppClear3 {
	
	public static void main(String[] args) {
		
		Session session = null;
		Student std1 = null;
		Student std2 = null;
		Student std3 = null;
		Student std4 = null;
		
		try {
			session = hibernateUtil.getSession();
			
			//performing read operation on database -- select query will be generated
			std1 = session.get(Student.class, 1); //via primary key
			System.out.println("std1 hashcode() :: " + std1.hashCode());
			
			//performing read operation on database -- select query will be generated
			std2 = session.get(Student.class, 5);
			System.out.println("std2 hashcode() :: " + std2.hashCode());
			
			//Clear all objects from L1 cache
			session.clear();
			
			//performing read operation on database -- select query will be generated
			std3 = session.get(Student.class, 1);
			System.out.println("std3 hashcode() :: " + std3.hashCode());
			
			
			//performing read operation on database -- select query will be generated.
			std4 = session.get(Student.class, 5);
			System.out.println("std4 hashcode() :: " + std4.hashCode());
				
			
		} catch(HibernateException he) {// copy paste
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
