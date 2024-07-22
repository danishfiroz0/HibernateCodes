package com.pwskills.danish.factory;

import com.pwskills.danish.controller.IStudentController;
import com.pwskills.danish.controller.StudentControllerImpl;

public class StudentControllerFactory {

	
		private static IStudentController controller = null;
		private StudentControllerFactory() {
			
		}
		public static IStudentController getController() {
			if(controller == null)
				controller = new StudentControllerImpl();
			return controller;
		}
	

}
