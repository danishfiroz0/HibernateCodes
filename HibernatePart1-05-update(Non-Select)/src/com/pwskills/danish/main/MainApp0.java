package com.pwskills.danish.main;


import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pwskill.danish.util.hibernateUtil;
import com.pwskills.danish.bean.Student;

//Hibernate is avoiding the creation of duplicate object. You have to update the details, in the same object.
//Their cannot be two object with the same primary key(identifier in one session).

public class MainApp0 {
	
	public static void main(String[] args) {
		
		Session session = null;
		Transaction transaction = null;
		BufferedReader br = null;
		Integer sid = null;
		Student student = null;
		String sname = null;
		Integer sage = null; 
		String saddress = null;
		boolean flag = false;
		
		try {
			session = hibernateUtil.getSession();
			if(session != null) {
				
				br= new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Enter sid to update Student other details.");
				sid = Integer.parseInt(br.readLine());
				
				student = session.get(Student.class, sid);
				
				if(student != null) {
					
					//beginning the process for updation - On a new created Object with same pk--> results in Exception
					Student studentForUpdation = new Student();
					transaction = session.beginTransaction();
					
					studentForUpdation.setSid(student.getSid());
					
					System.out.print("The old name is:: " + student.getSname() + "Enter new Name :: ");
					sname = br.readLine();
					if(sname == null || sname =="") {
						studentForUpdation.setSname(student.getSname());
					}else {
						studentForUpdation.setSname(sname);
					}
					
					System.out.print("The old age is:: " + student.getSage() + "Enter new Age :: ");
					sage = Integer.parseInt(br.readLine());
					if(sage == null || sname =="") {
						studentForUpdation.setSage(student.getSage());
					}else {
						studentForUpdation.setSage(sage);
					}
					
					System.out.print("The old address is:: " + student.getSaddress() + "Enter new address :: ");
					saddress = br.readLine();
					if(saddress == null || saddress =="") {
						studentForUpdation.setSaddress(student.getSaddress());
					}else {
						studentForUpdation.setSaddress(saddress);
					}
					
					session.saveOrUpdate(studentForUpdation);  // Exception
					
					flag = true;
				} else {
					System.out.println("RECORD NOT FOUND FOR THE GIVEN ID");
				}
				
			}
			
			//Result -- Exception
		} catch(HibernateException he) {
			he.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(flag) {
				transaction.commit();
				System.out.println("RECORD UPDATED SUCCESSFULLY");
				
				//Result -- Exception
			} else {
				System.out.println("RECORD UPDATION FAILED");
			}
			if(session != null) {
				hibernateUtil.closeResources(session);
			}
		}
	} 
	
}
