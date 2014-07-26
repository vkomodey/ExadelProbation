package com.exadel.dao.impl;

import com.exadel.dao.GenericLivingDao;
import com.exadel.model.IEntity;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
@Repository
public abstract class GenericLivingDaoImpl <ENTITY extends IEntity>
        extends HibernateDaoSupport implements GenericLivingDao<ENTITY> {
    @Autowired
    public void init(SessionFactory sessionFactory){
        setSessionFactory(sessionFactory);
    }

    public abstract ENTITY find(long id);
    public void save(ENTITY entity){
    		getSessionFactory().getCurrentSession().saveOrUpdate(entity);
    }
}
