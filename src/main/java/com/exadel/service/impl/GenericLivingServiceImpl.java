package com.exadel.service.impl;


import com.exadel.dao.GenericLivingDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exadel.dao.GenericDao;
import com.exadel.model.IEntity;
import com.exadel.service.GenericLivingService;
@Service
public abstract class GenericLivingServiceImpl<ENTITY extends IEntity> implements GenericLivingService<ENTITY> {
	private static Logger logger=LoggerFactory.getLogger(GenericLivingServiceImpl.class); 
	@Autowired
    GenericLivingDao<ENTITY> mainDao;
	@Transactional
	public ENTITY findById(long id){
		return mainDao.find(id);
	}
	@Transactional
	public void save(ENTITY entity){
		logger.info("service "+this.getClass()+" entity save");
		mainDao.save(entity);
		logger.info("service "+this.getClass()+" entity save done");
	}
}
