package com.exadel.dao;

import com.exadel.model.entity.Project;
import com.exadel.model.entity.student.Student;

import java.util.List;

public interface ProjectDao extends GenericDao<Project> {
    public void deleteProjectById(long id);

    public List<String> getAllStudentsFio(long projectId);

    public void addStudentOnProject(Student stud);


}
