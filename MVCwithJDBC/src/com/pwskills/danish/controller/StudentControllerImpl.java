package com.pwskills.danish.controller;

import com.pwskills.danish.dto.StudentDto;
import com.pwskills.danish.dto.StudentVo;
import com.pwskills.danish.factory.StudentServiceFactory;
import com.pwskills.danish.service.IStudentService;

public class StudentControllerImpl implements IStudentController {

	IStudentService service = StudentServiceFactory.getStudentService();
	@Override
	public String insertRecord(StudentVo stdVo)  {
		
		
		//Converting VO to DTO (this is done in Controller layer before sending the object, to service layer).
		StudentDto studentDto = new StudentDto();
		studentDto.setSname(stdVo.getSname());
		studentDto.setSage(Integer.parseInt(stdVo.getSage()));
		studentDto.setSaddress(stdVo.getSaddress());
		
		
		
		System.out.println("*****SENDING DTO TO SERVICE LAYER****");
		String rowAffected = service.insertRecord(studentDto);
		return rowAffected;
			
	}

	@Override
	public StudentVo readRecord(String sid) {
		StudentVo  stdVo = null;
		StudentDto stdDto = null;
		
		stdDto = service.readRecord(Integer.parseInt(sid));
		//convert from DTO to VO
		if(stdDto != null) {
			stdVo = new StudentVo();
			stdVo.setSid(String.valueOf(stdDto.getSid()));
			stdVo.setSname(stdDto.getSname());
			stdVo.setSage(String.valueOf(stdDto.getSid()));
			stdVo.setSaddress(stdDto.getSaddress());
			
		}
		
		return stdVo;
	}

	@Override
	public String deleteRecord(String sid) {
		return service.deletedRecord(Integer.parseInt(sid));
	}

	@Override
	public String updateRecord(StudentVo newStdVo) {
		
		//convert VO to DTO before sending to service layer
		
		StudentDto studentDto = new StudentDto();
		studentDto.setSid(Integer.parseInt(newStdVo.getSid()));
		studentDto.setSname(newStdVo.getSname());
		studentDto.setSage(Integer.parseInt(newStdVo.getSage()));
		studentDto.setSaddress(newStdVo.getSaddress());
		
		return service.updateRecord(studentDto);
	}

}

//Approach 2 -- with the help of API (not working though, don't know why) anyway, in maven you will be able to.
//			try {
//				BeanUtils.copyProperties(stdVo, stdDto);
//			} catch (IllegalAccessException | InvocationTargetException e) {
//				e.printStackTrace();
//			}