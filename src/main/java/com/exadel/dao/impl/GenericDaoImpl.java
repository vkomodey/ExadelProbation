package com.exadel.dao.impl;

import com.exadel.dao.GenericDao;
import com.exadel.model.IEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.io.Serializable;

public abstract class GenericDaoImpl <ENTITY extends IEntity, ID extends Serializable>
        extends HibernateDaoSupport implements GenericDao<ENTITY, ID> {
    @Autowired
    public void init(SessionFactory sessionFactory){
        setSessionFactory(sessionFactory);
    }


}
