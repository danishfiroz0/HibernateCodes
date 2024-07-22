package com.pwskills.danish.repository;

import com.pwskills.danish.dateobjects.StudentBo;

public interface IStudentRepo {
	public String insertRecord(StudentBo stdBo);
	public StudentBo readRecord(Integer sid);
	public String deleteRecord(Integer sid);
	public String updateRecord(StudentBo stdBo);

}
