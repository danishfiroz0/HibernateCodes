package com.pwskills.danish.service;

import com.pwskills.danish.dto.StudentBo;
import com.pwskills.danish.dto.StudentDto;
import com.pwskills.danish.factory.StudentRepoFactory;
import com.pwskills.danish.repository.IStudentRepo;

public class StudentServiceImpl implements IStudentService {
	
	IStudentRepo studentRepo =StudentRepoFactory.getStudentRepo();

	@Override
	public String insertRecord(StudentDto stdDto) {
		
		//Converting Dto to Bo(this is done in service layer, before sending the object to repositoroy layer.)
		StudentBo stdBo = new StudentBo();
		stdBo.setSname(stdDto.getSname());
		stdBo.setSage(stdDto.getSage());
		stdBo.setSaddress(stdDto.getSaddress());
		
		//some business logic
		if(stdBo.getSage()>= 60) {
			stdBo.setStatus("SeniorCitizen");
		} else {
			stdBo.setStatus("Working People");
		}
		
		
		return studentRepo.insertRecord(stdBo);
	}

	@Override
	public StudentDto readRecord(int sid) {
		StudentDto stdDto = null;
		StudentBo stdBo = null;
		
		stdBo = studentRepo.readRecord(sid);
		//convert BO to DTO
			//approach -1 Manual Conversion--
			if(stdBo != null) {
				stdDto = new StudentDto();
				stdDto.setSid(stdBo.getSid());
				stdDto.setSname(stdBo.getSname());
				stdDto.setSage(stdBo.getSage());
				stdDto.setSaddress(stdBo.getSaddress());
			}
		System.out.println(stdDto);
		return stdDto;
	}

	@Override
	public String deletedRecord(int sid) {
		return studentRepo.delelteRecord(sid);
	}

	@Override
	public String updateRecord(StudentDto studentDto) {
		
		//convert DTO to BO before sending it to repository layer
		
		StudentBo studentBo = new StudentBo();
		studentBo.setSid(studentDto.getSid());
		studentBo.setSname(studentDto.getSname());
		studentBo.setSage(studentDto.getSage());
		studentBo.setSaddress(studentDto.getSaddress());
		
		if(studentBo.getSage()>= 60) {
			studentBo.setStatus("SeniorCitizen");
		} else {
			studentBo.setStatus("Working People");
		}
		
		return studentRepo.updateRecord(studentBo);
	}

}

//approach -2 Through API help
//			try {
//				BeanUtils.copyProperties(stdDto, stdBo);
//			} catch (IllegalAccessException | InvocationTargetException e) {
//				e.printStackTrace();
//			}