package com.exadel.dao.impl;

import com.exadel.dao.CuratorDao;
import com.exadel.model.entity.government.Curator;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CuratorDaoImpl extends GenericLivingDaoImpl<Curator> implements CuratorDao{

    public Curator find(String login) {
        Session session = getSessionFactory().getCurrentSession();
        Curator cur = (Curator) session.bySimpleNaturalId(Curator.class).load(
                "login");
        return cur;
    }

    public Curator find(long id) {
        return (Curator) getSessionFactory().getCurrentSession().get(
                Curator.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Curator> getAll() {
        return getSessionFactory().getCurrentSession().createQuery("from Curator ").list();
    }

    public List<Curator> getSupervised(){
        return null;
    }



}
