package com.exadel.dao.impl;

import org.springframework.stereotype.Repository;

import com.exadel.dao.StudentDao;
import com.exadel.model.entity.student.Student;

@Repository
public class StudentDaoImpl extends GenericLivingDaoImpl<Student> implements StudentDao {
    public Student find(long id) {
        return (Student) getSessionFactory().getCurrentSession().get(Student.class, id);
    }
}
