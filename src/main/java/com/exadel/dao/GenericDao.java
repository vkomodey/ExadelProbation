package com.exadel.dao;

import java.util.List;


public interface GenericDao<ENTITY> {

	public abstract ENTITY find(long id);

	public abstract void save(ENTITY entity);

	public abstract List<ENTITY> getAll();

    public abstract void saveEntity(Object o);
}