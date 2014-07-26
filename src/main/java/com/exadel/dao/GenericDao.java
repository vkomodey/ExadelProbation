package com.exadel.dao;


public interface GenericDao<ENTITY> {

	public abstract ENTITY find(long id);

	public abstract void save(ENTITY entity);

}