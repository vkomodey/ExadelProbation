package com.exadel.dao;

import com.exadel.model.entity.student.Student;

import java.util.List;

public interface StudentDao extends GenericLivingDao<Student> {
    public List<Student> getSupervised(long id);

}
