package com.exadel.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.exadel.dao.GenericDao;
@Repository
public abstract class GenericDaoImpl<ENTITY> extends HibernateDaoSupport
		implements GenericDao<ENTITY> {

	@Autowired
	public void init(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	public abstract ENTITY find(long id);

	public void save(ENTITY entity) {
		getSessionFactory().getCurrentSession().saveOrUpdate(entity);
	}

}
