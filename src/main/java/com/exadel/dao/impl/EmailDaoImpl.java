package com.exadel.dao.impl;

import com.exadel.dao.EmailDao;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmailDaoImpl extends HibernateDaoSupport implements EmailDao {
    public List<String> getAllFioById(List<Long> listId){
        Query query = getSessionFactory().getCurrentSession().createQuery("from User where id IN (:listId)");
        query.setParameter("listId", listId);
        List <String> listFio = query.list();

        return null;
    }

    @Autowired
    public void init(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }
}
