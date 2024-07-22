package com.pwskills.danish.factory;

import com.pwskills.danish.service.IStudentService; //mark this line
import com.pwskills.danish.service.StudentServiceImpl;  //and this line

public class StudentServiceFactory {
	private static IStudentService studentService = null;  //here it is used
	
	private StudentServiceFactory() {
		
	}
	
	public static IStudentService getStudentService() {
		if(studentService == null)
			studentService = new StudentServiceImpl();  	//here it is used.
		
		return studentService;
	}
}
