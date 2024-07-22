package com.pwskills.danish.service;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.pwskills.danish.dateobjects.StudentBo;
import com.pwskills.danish.dateobjects.StudentDto;
import com.pwskills.danish.factory.StudentRepoFactory;
import com.pwskills.danish.repository.IStudentRepo;

public class StudentServiceImpl implements IStudentService {

	@Override
	public String insertRecord(StudentDto stdDto) {
		// Convert DTO to BO and send it to Repository layer
		System.out.println();
		StudentBo stdBo = new StudentBo();
		stdBo.setSname(stdDto.getSname());
		stdBo.setSaddress(stdDto.getSaddress());
		stdBo.setSage(stdDto.getSage());

		

		System.out.println("****SENDING BO TO REPOSITORY LAYER****\n");
		IStudentRepo repo = StudentRepoFactory.getStudentRepo();
		return repo.insertRecord(stdBo);
	}

	@Override
	public StudentDto readRecord(Integer sid) {

		IStudentRepo repo = StudentRepoFactory.getStudentRepo();
		StudentBo bo = null;
		StudentDto dto = null;

		bo = repo.readRecord(sid);

		// convert bo to dto and send
		if (bo == null) {
			return dto;
		} else {
			try {
				dto = new StudentDto();
				// copy data from bo to dto
				BeanUtils.copyProperties(dto, bo);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}

		return dto;
	}

	@Override
	public String deleteRecord(Integer sid) {
		IStudentRepo repo = StudentRepoFactory.getStudentRepo();
		return repo.deleteRecord(sid);
	}

	@Override
	public String updateRecord(StudentDto stdDto) {
		
		StudentBo stdBo = new StudentBo();
		stdBo.setSid(stdDto.getSid());
		stdBo.setSname(stdDto.getSname());
		stdBo.setSaddress(stdDto.getSaddress());
		stdBo.setSage(stdDto.getSage());


		System.out.println("****SENDING BO TO REPOSITORY LAYER****\n");
		IStudentRepo repo = StudentRepoFactory.getStudentRepo();
		
		return repo.updateRecord(stdBo);
	}
}
