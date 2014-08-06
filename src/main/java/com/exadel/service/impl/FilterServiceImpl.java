package com.exadel.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exadel.dao.CuratorDao;
import com.exadel.dao.StudentDao;
import com.exadel.model.entity.User;
import com.exadel.model.entity.student.Student;
import com.exadel.model.entity.student.Technology;
import com.exadel.service.FilterService;
@Service
public class FilterServiceImpl implements FilterService {
	@Autowired
	StudentDao studentDao;
	@Autowired
	CuratorDao curatorDao;
	@Transactional
	public List<String> getAllUniversities() {
		return studentDao.getUniversities();
	}
	@Transactional
	public Set<Technology> getAllCurrentUsedTechnologies() {
		List<Student> list=studentDao.getAll();
		Set<Technology> technologies=new HashSet<>();
		for(Student stud:list){
			technologies.addAll(stud.getWork().getCurrentUsedTechnologies());
		}
		return technologies;
	}
	@Transactional
	public List<String> getAllFaculties() {
		
		return studentDao.getFaculties();
	}
	@Transactional
	public List<Long> getAllStudyEndYears() {
		return studentDao.getStudyEndYears();
	}
	@Transactional
	public Set<User> getAllUsedCurators() {
		return new HashSet<User>(curatorDao.getActive());
	}

}
