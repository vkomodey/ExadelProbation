package com.exadel.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.exadel.dao.GenericDao;
@Repository
public abstract class GenericDaoImpl<ENTITY> extends HibernateDaoSupport
		implements GenericDao<ENTITY> {

	public abstract ENTITY find(long id);

	@Autowired
	public void init(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	public void save(ENTITY entity) {
        try{
		getSessionFactory().getCurrentSession().saveOrUpdate(entity);
        }catch (Exception e){
            e.printStackTrace();
        }
	}

    public void saveEntity(Object o){
        getSessionFactory().getCurrentSession().saveOrUpdate(o);
    }
}
