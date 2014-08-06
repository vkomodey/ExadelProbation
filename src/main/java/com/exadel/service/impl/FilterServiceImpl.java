package com.exadel.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.exadel.dao.StudentDao;
import com.exadel.model.entity.User;
import com.exadel.model.entity.student.Student;
import com.exadel.model.entity.student.Technology;
import com.exadel.service.FilterService;

public class FilterServiceImpl implements FilterService {
	@Autowired
	StudentDao studentDao;

	public List<String> getAllUniversities() {
		return studentDao.getUniversities();
	}

	public Set<Technology> getAllCurrentUsedTechnologies() {
		// TODO Auto-generated method stub
		List<Student> list=studentDao.getAll();
		Set<Technology> technologies=new HashSet<>();
		for(Student stud:list){
			technologies.addAll(stud.getWork().getCurrentUsedTechnologies());
		}
		return technologies;
	}

	public List<String> getAllFaculties() {
		
		return studentDao.getFaculties();
	}

	public List<Long> getAllStudyEndYears() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> getAllUsedCurators() {
		// TODO Auto-generated method stub
		return null;
	}

}
