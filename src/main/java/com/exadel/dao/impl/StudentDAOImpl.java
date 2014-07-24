/*
package com.exadel.dao.impl;

import com.exadel.dao.StudentDAO;
import com.exadel.model.entity.User;
import com.exadel.model.entity.student.Student;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class StudentDAOImpl extends GenericDaoImpl<Student, Integer> implements StudentDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Student get(Long id) {
        return null;
    }

    @Override
    public Student save(Student stud) {
        org.hibernate.Session s = getSessionFactory().openSession();
        s.save(stud);
        return null;
    }

    @Override
    public Collection<Student> find(String text) {
        return null;
    }

    @Override
    public Student find(Integer integer) {
        return null;
    }
}
*/
