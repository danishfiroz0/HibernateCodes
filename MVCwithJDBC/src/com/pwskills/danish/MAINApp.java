package com.pwskills.danish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.pwskills.danish.controller.IStudentController;
import com.pwskills.danish.dto.StudentVo;
import com.pwskills.danish.factory.StudentControllerFactory;


//UI PAGE:: this way, bcs it is standalone application/console application/ at a time this application can be used by one people/ no server requied to run this application, it is run in your local machine.
public class MAINApp {
	
	//main() : Driver Code
	public static void main(String[] args) throws IOException {
	
		IStudentController controller = StudentControllerFactory.getController();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("*********WELCOMET TO STUDENT APPLICATION*****");
			System.out.println("1. INSERT");
			System.out.println("2. READ");
			System.out.println("3. DELETE");
			System.out.println("4. UPDATE");
			System.out.println("5. EXIT");
			System.out.print("ENTER YOUR CHOICE[1/2/3/4/5]:: ");
			
			String option = br.readLine();
			
			switch(option) {
			case "1": 
				insertRecord(br , controller);
				break;
				
			case "2": 
				readRecord(br, controller);
				break;
				
			case "3":
				deleteRecord(br, controller);
				break;
				
			case "4":
				updateRecord(br, controller);
				break;
				
			case "5": 
				System.out.println("***THANKS FOR USING THE APPLICATION***");
				System.exit(0);
				break;
			
				
					
			default:
				break;
			}
		}

	}

	private static void updateRecord(BufferedReader br, IStudentController controller) throws IOException {
		System.out.println("Enter sid to update the record");
		String sid = br.readLine();
		
		StudentVo stdVo = controller.readRecord(sid);
		
		if(stdVo != null) {
			StudentVo newStdVo = new StudentVo();
			
			//sid should not be altered
			newStdVo.setSid(stdVo.getSid());
			
			//updating sname
			System.out.println("Old name is :: " + stdVo.getSname() + " Enter new Name ");
			String newSname = br.readLine();
			
			if(newSname.equals("") || newSname == "") {
				newStdVo.setSname(stdVo.getSname());
			}else {
				newStdVo.setSname(newSname);
			}
			
			
			//updating sage
			System.out.println("Old age is :: " + stdVo.getSage() + " Enter new age ");
			String newSage= br.readLine();
			
			if(newSage.equals("") || newSage == "") {
				newStdVo.setSage(stdVo.getSage());
			}else {
				newStdVo.setSage(newSage);
			}
			
			//updating saddress
			System.out.println("Old address is :: " + stdVo.getSaddress() + " Enter new Address ");
			String newSaddress = br.readLine();
			
			if(newSaddress.equals("") || newSaddress == "") {
				newStdVo.setSaddress(stdVo.getSaddress());
			}else {
				newStdVo.setSaddress(newSaddress);
			}
			
			//sending the newStdVo for update.
			String status = controller.updateRecord(newStdVo);
			System.out.println(status);
		} else {
			System.out.println("No records found to update");
		}
	}

	private static void deleteRecord(BufferedReader br, IStudentController controller) throws IOException {
		
		System.out.println("Enter sid to delete the record: ");
		String sid = br.readLine();
		
		String status = controller.deleteRecord(sid);
		
		System.out.println(status);
		
	}

	private static void readRecord(BufferedReader br, IStudentController controller) throws IOException {
		
		System.out.println("Enter the sid");
		String sid = br.readLine();
		
		StudentVo stdVo = null;
		
		stdVo = controller.readRecord(sid);
		if(stdVo != null) {
			System.out.println(stdVo);
		} else {
			System.out.println("Record not found for the given sid...");
		}
	}

	private static void insertRecord(BufferedReader br, IStudentController controller) throws IOException {
		
		
		
		System.out.println("Enter the sname:: ");
		String sname = br.readLine();
		System.out.println("Enter the age:: ");
		String sage = br.readLine();
		System.out.println("Enter the saddress::");
		String saddress = br.readLine();
		
		
		
		StudentVo student = new StudentVo();
		
		student.setSname(sname);
		student.setSage(sage);
		student.setSaddress(saddress);
		
		
		System.out.println("*****SENDING VO TO CONTROLLER");
		String status = controller.insertRecord(student);
		if(status.equalsIgnoreCase("success")) {
			System.out.println("Record inserted successfully!");
		}else {
			System.out.println(status);
		}
	}

}
