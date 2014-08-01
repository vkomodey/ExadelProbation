package com.exadel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exadel.dao.TypesDao;
import com.exadel.model.entity.student.SkillType;
import com.exadel.service.TypesService;
@Service
public class TypesServiceImpl implements TypesService {
	@Autowired
	TypesDao typesDao;
	@Transactional
	public List<SkillType> getAllSkillTypes() {
		return typesDao.getAll();
	}

}
