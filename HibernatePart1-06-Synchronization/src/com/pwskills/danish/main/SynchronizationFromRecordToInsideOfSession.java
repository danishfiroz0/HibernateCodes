package com.pwskills.danish.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.pwskill.danish.util.hibernateUtil;
import com.pwskills.danish.bean.Student;


//Changes in database record and automatically synchronized with Session Object. and vice-versa
public class SynchronizationFromRecordToInsideOfSession {

	public static void main(String[] args) {

		Session session = null;
		Student student = null;

		try {
			session = hibernateUtil.getSession();

			student = session.get(Student.class, 3);
			System.out.println("Before modification.....");
			System.out.println("Record with the id value :: " + student);
			
			//application is in pausing state
			System.in.read();

			//synchronization established b/w record to java object
			session.refresh(student); //
			
			System.out.println("After modification....");
			System.out.println("Record with the id value :: "+student);
			
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			hibernateUtil.closeResources(session);
		}

	}

}

