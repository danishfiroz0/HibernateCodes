//Concept of L1 cache - part2
package com.pwskills.danish.main;


import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.pwskill.danish.util.hibernateUtil;
import com.pwskills.danish.bean.Student;

public class MainApp2 {
	
	public static void main(String[] args) {
		
		Session session = null;
		Scanner scanner = null;
		Integer sid = null;
		Student std1 = null;
		Student std2 = null;
		
		try {
			session = hibernateUtil.getSession();
			scanner = new Scanner(System.in);
			
			if(scanner!= null && session!= null) {
				System.out.print("Enter sid :: ");
				sid = scanner.nextInt();
				
				//performing read operation on database -- select query will be generated
				std1 = session.get(Student.class, sid);
				System.out.println("std1 hashcode() :: " + std1.hashCode());
				
				//clearing the cache
				session.clear();
				
				//performing read operation on database -- select query will be generated.
				std2 = session.get(Student.class, sid);
				System.out.println("std2 hashcode() :: " + std2.hashCode());
				
			}
			
			
			
		
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
