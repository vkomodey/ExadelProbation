package com.exadel.dao.impl;

import com.exadel.dao.EmailDao;
import com.exadel.model.entity.student.Student;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailDaoImpl extends HibernateDaoSupport implements EmailDao {
    public List<String> getAllEmailsById(List<Long> listId){
        List <Student> studentList = getSessionFactory().getCurrentSession().
                createQuery("from Student where id IN (:listId)").
                setParameterList("listId", listId).list();
        List<String> emailList = new ArrayList<String>();
        for(int i = 0; i < studentList.size(); ++i){
            emailList.add(studentList.get(i).getEmail());
        }
        return emailList;
    }

    @Autowired
    public void init(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }
}
