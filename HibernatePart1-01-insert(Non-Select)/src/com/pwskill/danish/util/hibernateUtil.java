package com.pwskill.danish.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pwskills.danish.bean.Student;

public class hibernateUtil {
	
	//Configuration Object and SessionFactory object should be created only onece
	
	private static SessionFactory sessionFactory = null;
	private static Session session = null;
	
	static {
		if(sessionFactory == null) {
			sessionFactory = new Configuration()
								.configure()
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		}
	}
	
	
	public static Session getSession() {
		if(sessionFactory != null) {
			session =  sessionFactory.openSession();
		}
		return session;
	}
	
	public static void closeResources(Session session) {
		if(session != null) {
			session.close();
		}
		if(sessionFactory!=null) {
			sessionFactory.close();
		}
	}
}
