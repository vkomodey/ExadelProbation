package com.exadel.service.impl;

import java.util.List;

import com.exadel.controller.json.constants.StudURI;
import com.exadel.model.constants.StudentStateEnum;
import com.exadel.model.entity.student.Technology;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exadel.dao.TechDao;
import com.exadel.service.TypesService;
@Service
public class TypesServiceImpl implements TypesService {
	@Autowired
	TechDao typesDao;

    @Transactional
	public List<Technology> getAllTechs() {
		return typesDao.getAll();
	}
    
    @Transactional
	public List<String> getActiveTechs() {
		return typesDao.getActiveNames();
	}
}
