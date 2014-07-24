package com.exadel.dao;


import com.exadel.model.entity.User;
import com.exadel.model.entity.student.Student;

import java.util.Collection;

public interface StudentDAO extends GenericDao<User, Integer>{

    Student get(Long id);

    Student save(Student stud);

    Collection<Student> find(String text);

}
