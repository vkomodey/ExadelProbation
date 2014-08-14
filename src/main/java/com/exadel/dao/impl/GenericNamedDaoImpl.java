package com.exadel.dao.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.exadel.dao.GenericNamedDao;
import com.exadel.model.NamedEntity;
@Repository
public abstract class GenericNamedDaoImpl <ENTITY extends NamedEntity>
        extends GenericDaoImpl<ENTITY> implements GenericNamedDao<ENTITY> {
	@SuppressWarnings("unchecked")
	public ENTITY find(String login) {
		return (ENTITY) getSessionFactory().getCurrentSession()
				.bySimpleNaturalId(typeString).load(login);
    }
	public void deleteAll(){
		Session session=getSessionFactory().getCurrentSession();
		session.createQuery("delete from "+typeString).executeUpdate();
	}
}
