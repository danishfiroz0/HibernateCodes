package com.pwskills.danish.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pwskill.danish.util.hibernateUtil;
import com.pwskills.danish.bean.Student;

public class SynchronizationFromInsideSessionToRecord {
	public static void main(String[] args) {

		Session session = null;
		Student student = null;
		boolean flag = false;
		Transaction transaction = null;
		int id = 4;

		try {
			session = hibernateUtil.getSession();

			// Getting the record in the form of student object(session)
			student = session.get(Student.class, id);
			
			
			if (student != null) {
				transaction = session.beginTransaction();
				
				//before modification
				System.out.println("Before modification :: " + student);

				//application in pausing state
				System.in.read();

				// modifying the data
				student.setSname("dhoni");

				flag = true;

			} else {
				System.out.println("Record not found for the id :: " + id);
			}

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("After modification :: " + student);
			} else {
				transaction.rollback();
			}
			hibernateUtil.closeResources(session);
			}
		}
}


