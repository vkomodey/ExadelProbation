package com.exadel.dao.impl;

import com.exadel.dao.GenericDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
@Repository
public abstract class GenericDaoImpl<ENTITY> extends HibernateDaoSupport
		implements GenericDao<ENTITY> {

	public abstract ENTITY find(long id);

	@Autowired
	public void init(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	public void save(ENTITY entity) {
		getSessionFactory().getCurrentSession().saveOrUpdate(entity);
	}

}
