



package com.pwskills.danish.main;


import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.pwskill.danish.util.hibernateUtil;
import com.pwskills.danish.bean.Student;

public class MainAppLoad {
	
	public static void main(String[] args) {
		
		Session session = null;
		Scanner scanner = null;
		Integer sid = null;
		Student student = null;
		
		try {
			session = hibernateUtil.getSession();
			scanner = new Scanner(System.in);
			
			if(scanner!= null && session!= null) {
				System.out.print("Enter sid :: ");
				sid = scanner.nextInt();
				
				//performing read operation on database
				student = session.load(Student.class, sid);
			}
			System.in.read();
			
			//if student object has been retrived then display it.
			if(student != null) {
				System.out.println("STUDENT DETAILS");
				System.out.println("SID IS:: " + student.getSid());
				System.out.println("SNAME IS:: " + student.getSname());
				System.out.println("SADDRESS IS:: " + student.getSaddress());
				System.out.println("SAGE IS:: " + student.getSage());
			} else {
				System.out.println("Record not avaiable for the given sid.");
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
