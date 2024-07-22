package com.pwskills.danish.repository;


import com.pwskills.danish.dto.StudentBo;


public interface IStudentRepo {
		//Create
		//Read
		//Update
		//Delete
		
		public String insertRecord(StudentBo student);

		public StudentBo readRecord(int sid);

		public String delelteRecord(int sid);

		public String updateRecord(StudentBo studentBo);
		
}