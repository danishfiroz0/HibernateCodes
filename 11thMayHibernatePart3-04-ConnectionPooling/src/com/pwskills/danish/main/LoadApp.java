package com.pwskills.danish.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pwskill.danish.util.HibernateUtil;
import com.pwskills.danish.bean.MobileCustomer;

public class LoadApp {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		MobileCustomer customer = null;
		
		Boolean flag = false;

		try {
			session = HibernateUtil.getSession();

			int id = 1;
			customer = session.get(MobileCustomer.class, id);

			if (customer != null) {

				System.out.println(customer);
				transaction = session.beginTransaction();
				
				//when you make a change with the Object present in the cache of Session Object, it will be synchronized with the record in database.
				//if no change is made(or, setting the same which already is), Hibernate will not consider to update Version Count.
				customer.setCallerTune("whistle podu....");
				flag = true;

			} else {
				System.out.println("Record not found for the id :: " + id);
			}

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (transaction != null) {
				if (flag) {
					transaction.commit();
					System.out.println("Record inserted/updated succesfully...");
					System.out.println("object is modified for :: "+customer.getVersionCount() + " times");
				} else {
					transaction.rollback();
					System.out.println("Record failed for updation...");
				}

				HibernateUtil.closeSessionFactory();
				if (session != null) {
					session.close();
				}
			}
		}
	}
}
