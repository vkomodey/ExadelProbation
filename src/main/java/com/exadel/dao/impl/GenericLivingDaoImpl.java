package com.exadel.dao.impl;

import org.springframework.stereotype.Repository;

import com.exadel.dao.GenericLivingDao;
import com.exadel.model.IEntity;
@Repository
public class GenericLivingDaoImpl <ENTITY extends IEntity>
        extends GenericDaoImpl<ENTITY> implements GenericLivingDao<ENTITY> {
	@SuppressWarnings("unchecked")
	public ENTITY find(String login) {
		return (ENTITY) getSessionFactory().getCurrentSession()
				.bySimpleNaturalId(typeString).load(login);
    }
}
