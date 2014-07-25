package com.exadel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.exadel.dao.impl.GenericLivingDaoImpl;
import com.exadel.model.IEntity;
import com.exadel.service.GenericLivingService;

public abstract class GenericLivingServiceImpl<ENTITY extends IEntity> implements GenericLivingService<ENTITY> {
	@Autowired
	GenericLivingDaoImpl<ENTITY> dao;
	public ENTITY findById(long id){
		return dao.find(id);
	}
}
