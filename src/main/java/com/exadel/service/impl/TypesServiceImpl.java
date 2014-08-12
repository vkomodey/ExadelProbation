package com.exadel.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.exadel.model.NamedEntity;
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
	
	private List<String> getNamesFromNamed(List<? extends NamedEntity> list){
		List<String> res=new ArrayList<String>(list.size());
		for(NamedEntity u:list){
			res.add(u.getName());
		}
		return res;
	}
	
    @Transactional
	public List<Technology> getAllTechs() {
		return techDao.getAll();
	}
    
    @Transactional
	public List<String> getActiveTechs() {
    	List<Technology> list=techDao.getAllCurrentUsedByStudents();
		return getNamesFromNamed(list);
	}
    @Transactional
	public List<University> getAllUniversities() {
		return universityDao.getAll();
	}
    @Transactional
	public List<String> getActiveUniversities() {
		List<University> list=studentDao.getActiveUniversities();
		return getNamesFromNamed(list);
	}
    @Transactional
	public List<Faculty> getAllFaculties() {
		return facultyDao.getAll();
	}
    @Transactional
	public List<String> getActiveFaculties() {
		List<Faculty> list=studentDao.getActiveFaculties();
		return getNamesFromNamed(list);
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
