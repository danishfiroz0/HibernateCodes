package com.pwskills.danish.main;

import java.io.FileInputStream;
import java.io.FileReader;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pwskill.danish.util.hibernateUtil;
import com.pwskills.danish.bean.ResumeImage;

public class InsertImageResume1 {
	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		FileInputStream fis = null;
		FileReader fr = null;
		byte[] image = null;
		char[] resume = null;
		Boolean flag = false;

		try {
			session = hibernateUtil.getSession();
			
			if(session != null) {
				fis = new FileInputStream("/Users/danishfiroz/Desktop/clutters/SampleJPGImage_30mbmb.jpg");
				if(fis!= null) {
					image=new byte[fis.available()];
					fis.read(image);
				}
				
				
				//Perhaps Not Working.
//				File file = new File("/Users/danishfiroz/Desktop/clutters/resume.txt");
//				fr = new FileReader(file);
//				if(fr!= null) {
//					resume =new char[(int)file.length()];
//					fr.read(resume);
//				}
				
				ResumeImage ri  = new ResumeImage();
				ri.setName("Danish");
				ri.setImage(image);
				//ri.setResume(resume);
				
				
				//Hibernate part
				session.saveOrUpdate(ri);
				flag = true;
			}
		} catch (Exception e) {

		} finally {
			if(flag) {
				System.out.println("Record inserted successfully");
				hibernateUtil.closeResources(session);
			}
		}
	}
}
