package com.pwskills.danish.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pwskill.danish.util.hibernateUtil;
import com.pwskills.danish.bean.ProgramCompositeId;
import com.pwskills.danish.bean.ProgrammerProjectInfo;

public class SaveApp {
	public static void main(String[] args) {
		
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		
		try {
			session = hibernateUtil.getSession();
			
			if(session != null) {
				transaction = session.beginTransaction();
				{
					if(transaction != null) {
						
						ProgramCompositeId id  = new ProgramCompositeId();
						id.setPid(100);
						id.setProjId(500);
						
						ProgrammerProjectInfo info = new ProgrammerProjectInfo();
						info.setId(id);
						info.setpName("Danish");
						info.setProjName("Hibernate");
						
						session.save(info);
						flag = true;
					}
				}
			}
		} catch(HibernateException he) {
			
		} catch(Exception e) {
			
		} finally {
			if(flag) {
				transaction.commit();
				System.out.println("Record saved successfully");
			}
			hibernateUtil.closeResources(session);
		}
	}
}	
