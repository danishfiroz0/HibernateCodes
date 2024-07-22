package com.pwskills.danish.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.pwskill.danish.util.hibernateUtil;
import com.pwskills.danish.bean.PersonInfo;

public class GetApp2 {
	public static void main(String[] args) {
		
		Session session = null;
		
		try {
			session = hibernateUtil.getSession();
			
			if(session != null) {
				PersonInfo person = session.get(PersonInfo.class, 1);
				
				if(person!= null) {
					System.out.println(person);
				} else {
					System.out.println("record not found");
				}
			}
		} catch(HibernateException he) {
			
		} catch(Exception e) {
			
		}
	}
}
