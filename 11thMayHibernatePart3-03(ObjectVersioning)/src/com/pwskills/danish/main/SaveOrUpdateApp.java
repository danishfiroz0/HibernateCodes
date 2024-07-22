//checkout loadApp -- this is not the concept

package com.pwskills.danish.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pwskill.danish.util.HibernateUtil;
import com.pwskills.danish.bean.MobileCustomer;

public class SaveOrUpdateApp {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;

		Boolean flag = false;

		// logic for HIBERNATE working
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();

			MobileCustomer customer = new MobileCustomer();
			customer.setCname("rohith");
			customer.setCallerTune("duniye hila denge...");
			customer.setMobileNo(9966553344L);

			session.saveOrUpdate(customer);

			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (transaction != null) {
				if (flag) {
					transaction.commit();
					System.out.println("Record inserted/updated succesfully...");
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
