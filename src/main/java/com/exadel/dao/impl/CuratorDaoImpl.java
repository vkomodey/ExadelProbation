package com.exadel.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.exadel.dao.CuratorDao;
import com.exadel.model.entity.government.Curator;
import com.exadel.model.entity.student.Student;

@Repository
public class CuratorDaoImpl extends GenericLivingDaoImpl<Curator> implements CuratorDao{

    public Curator find(String login) {
        Session session = getSessionFactory().getCurrentSession();
        Curator cur = (Curator) session.bySimpleNaturalId(Curator.class).load(
                login);
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

    public List<Student> getSupervised(long CuratorId){
        return ((Curator)getSessionFactory().getCurrentSession().get(Curator.class,CuratorId)).getStudents();
    }

}
