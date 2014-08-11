package com.exadel.service.impl;

import java.util.List;

import com.exadel.controller.json.constants.StudURI;
import com.exadel.model.constants.StudentStateEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exadel.dao.SkillTypeDao;
import com.exadel.model.entity.student.SkillType;
import com.exadel.service.TypesService;
@Service
public class TypesServiceImpl implements TypesService {
	@Autowired
	SkillTypeDao typesDao;

    public TypesServiceImpl() {
        states.add(StudentStateEnum.PRACTICE.toString());
        states.add(StudentStateEnum.PROBATION.toString());
        states.add(StudentStateEnum.WORK.toString());
    }

    @Transactional
	public List<SkillType> getAllSkillTypes() {
		return typesDao.getAll();
	}

}
