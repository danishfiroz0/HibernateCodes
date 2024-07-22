package com.pwskills.danish.controller;

import com.pwskills.danish.dto.StudentVo;

public interface IStudentController {
	
	//Create
	//Read
	//Update
	//Delete
	
	public String insertRecord(StudentVo student);

	public StudentVo readRecord(String sid);

	public String deleteRecord(String sid);

	public String updateRecord(StudentVo newStdVo);

}
