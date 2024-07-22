package com.pwskills.danish.main;


import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pwskill.danish.util.hibernateUtil;
import com.pwskills.danish.bean.Student;

//Hibernate is avoiding the creation of duplicate object. You have to update the details, in the same object.

public class MainApp1 {
	
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
				System.out.println("Enter sid to update its other details.");
				sid = Integer.parseInt(br.readLine());
				
				student = session.get(Student.class, sid);
				
				//if record available then, beginning the process for updation / In the same Object we are making the changes for updation.
				if(student != null) {
					
					
					transaction = session.beginTransaction();
					
					if(transaction != null) {
						
						
						student.setSid(student.getSid());
						
						System.out.print("The old name is:: " + student.getSname() + "Enter new Name :: ");
						sname = br.readLine();
						if(sname == null || sname =="") {
							student.setSname(student.getSname());
						}else {
							student.setSname(sname);
						}
						
						System.out.print("The old age is:: " + student.getSage() + "Enter new Age :: ");
						sage = Integer.parseInt(br.readLine());
						if(sage == null || sname =="") {
							student.setSage(student.getSage());
						}else {
							student.setSage(sage);
						}
						
						System.out.print("The old address is:: " + student.getSaddress() + "Enter new address :: ");
						saddress = br.readLine();
						if(saddress == null || saddress =="") {
							student.setSaddress(student.getSaddress());
						}else {
							student.setSaddress(saddress);
						}
						
						session.saveOrUpdate(student);
						
						flag = true;
					}
					
				//if record not available then, beginning the process for insertion
				} else {
					transaction = session.beginTransaction();
					
					student = new Student();
					student.setSname("Nikita");
					student.setSage(21);
					student.setSaddress("Varanasi");
					
					session.saveOrUpdate(student); 
					transaction.commit();
					
					System.out.println("New Record Inserted");
					
					flag =  true;
				}
				
			}
			
		} catch(HibernateException he) {// copy paste
			he.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(flag) {
				transaction.commit();
				System.out.println("RECORD UPDATED SUCCESSFULLY");
			} else {
				System.out.println("RECORD UPDATION FAILED");
			}
			if(session != null) {
				hibernateUtil.closeResources(session);
			}
		}
	} 
	
}
