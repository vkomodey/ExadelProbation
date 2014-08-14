package com.exadel.dao;

import com.exadel.model.NamedEntity;

public interface GenericNamedDao<T extends NamedEntity> extends GenericDao<T> {
	public T find(String name);

	public void deleteAll();
}
