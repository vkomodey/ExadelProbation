package com.exadel.dao.impl;

import org.springframework.stereotype.Repository;

import com.exadel.dao.GenericLivingDao;
import com.exadel.dao.GenericNamedDao;
import com.exadel.model.IEntity;
import com.exadel.model.NamedEntity;
@Repository
public class GenericNamedDaoImpl <ENTITY extends NamedEntity>
        extends GenericDaoImpl<ENTITY> implements GenericNamedDao<ENTITY> {
	@SuppressWarnings("unchecked")
	public ENTITY find(String login) {
		return (ENTITY) getSessionFactory().getCurrentSession()
				.bySimpleNaturalId(typeString).load(login);
    }
}
