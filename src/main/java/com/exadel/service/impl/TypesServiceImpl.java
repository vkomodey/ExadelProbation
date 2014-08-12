package com.exadel.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.exadel.model.entity.student.Faculty;
import com.exadel.model.entity.student.Technology;
import com.exadel.model.entity.student.University;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exadel.dao.GenericNamedDao;
import com.exadel.dao.StudentDao;
import com.exadel.dao.TechDao;
import com.exadel.service.TypesService;
@Service
public class TypesServiceImpl implements TypesService {
	@Autowired
	GenericNamedDao<University> universityDao;
	@Autowired
	StudentDao studentDao;
	@Autowired
	TechDao techDao;
	@Autowired
	GenericNamedDao<Faculty> facultyDao;
    @Transactional
	public List<Technology> getAllTechs() {
		return techDao.getAll();
	}
    
    @Transactional
	public List<String> getActiveTechs() {
		return techDao.getActiveNames();
	}
    @Transactional
	public List<University> getAllUniversities() {
		return universityDao.getAll();
	}
    @Transactional
	public List<String> getActiveUniversities() {
		List<University> list=studentDao.getActiveUniversities();
		List<String> res=new ArrayList<String>(list.size());
		for(University u:list){
			res.add(u.getName());
		}
		return res;
	}
    @Transactional
	public List<Faculty> getAllFaculties() {
		return facultyDao.getAll();
	}
    @Transactional
	public List<String> getActiveFaculties() {
		List<Faculty> list=studentDao.getActiveFaculties();
		List<String> res=new ArrayList<String>(list.size());
		for(Faculty f:list){
			res.add(f.getName());
		}
		return res;
	}
    @Transactional
	public void push(University university) {
		universityDao.save(university);
		
	}
    @Transactional
	public void push(Faculty faculty) {
		facultyDao.save(faculty);
		
	}
}
