package com.pwskills.danish.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.pwskill.danish.util.hibernateUtil;
import com.pwskills.danish.bean.ProgramCompositeId;
import com.pwskills.danish.bean.ProgrammerProjectInfo;

public class GetApp {

	public static void main(String[] args) {

		Session session = null;

		try {
			session = hibernateUtil.getSession();

			ProgramCompositeId id = new ProgramCompositeId();
			id.setPid(100);
			id.setProjId(500);

			ProgrammerProjectInfo info = session.get(ProgrammerProjectInfo.class, id);  //2 id is needed, to retrieve a entity with composite primary key identifier.
			if (info != null) {
				System.out.println(info);
			} else {
				System.out.println("Record not found for the id :: " + id);
			}

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			hibernateUtil.closeResources(session);
		}
	}
}

