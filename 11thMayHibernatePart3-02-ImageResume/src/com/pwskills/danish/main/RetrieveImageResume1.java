package com.pwskills.danish.main;

import java.io.FileOutputStream;
import java.io.FileWriter;

import org.hibernate.Session;

import com.pwskill.danish.util.hibernateUtil;
import com.pwskills.danish.bean.ResumeImage;

public class RetrieveImageResume1 {
	public static void main(String[] args) {

		Session session = null;
		boolean flag = false;
		
		
		try {
			session = hibernateUtil.getSession();
			
			if(session != null) {
				
				//Hibernate part
				ResumeImage ri = session.load(ResumeImage.class, 1);
				
				byte[] image = new byte[ri.getImage().length];
				image = ri.getImage();
				FileOutputStream fos = new FileOutputStream("/Users/danishfiroz/Desktop/clutters/image_copy.jpg");
				fos.write(image);
				
				char[] resume = new char[ri.getResume().length];
				resume = ri.getResume();
				FileWriter fw = new FileWriter("/Users/danishfiroz/Desktop/clutters/resume_copy.txt");
				fw.write(resume);
				
				flag = true;
				
			}
		} catch (Exception e) {

		} finally {
			if(flag){
				System.out.println("Downloaded both successfully.");
			}
			hibernateUtil.closeResources(session);
			}
		}
	}
