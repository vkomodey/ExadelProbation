package com.exadel.dao;

import java.util.List;

import com.exadel.model.entity.student.Student;

public interface StudentDao extends GenericLivingDao<Student> {
    public List<Student> getSupervised(long id);
    void updateStudent(Student st);
}
