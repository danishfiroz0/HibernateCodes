package com.pwskills.danish.service;

import com.pwskills.danish.dto.StudentDto;

public interface IStudentService {
		
		//Create
		//Read
		//Update
		//Delete
		
		public String insertRecord(StudentDto student) ;

		public StudentDto readRecord(int sid);

		public String deletedRecord(int sid);

		public String updateRecord(StudentDto studentDto);

	

}
