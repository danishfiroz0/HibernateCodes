package com.pwskills.danish.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pwskills.danish.bean.Student;

public class MainApp {
	
	public static void main(String[] args) {
		
		//Bootstraping the hibernate
		Configuration configuration = new Configuration();
		configuration.configure();
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		//using session object start a transaction
		Transaction transaction = session.beginTransaction();
		
		Student std = new Student();
		std.setSname("tamanna");
		std.setSage(19);
		std.setSaddress("rasra");
		
		//generates insert query at the backend by Hibernate
		session.save(std);
		
		transaction.commit();
		session.close();
	} 
	
}
