package com.exadel.service.impl;


import com.exadel.model.IEntity;
import com.exadel.service.GenericLivingService;
public abstract class GenericLivingServiceImpl<ENTITY extends IEntity> implements GenericLivingService<ENTITY> {
	public abstract ENTITY findById(long id);
	public abstract ENTITY findByLogin(String name);
	public abstract void save(ENTITY entity);

}
