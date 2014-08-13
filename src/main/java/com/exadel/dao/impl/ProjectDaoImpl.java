package com.exadel.dao.impl;

import com.exadel.dao.ProjectDao;
import com.exadel.model.entity.Project;
import com.exadel.model.entity.student.Student;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProjectDaoImpl extends GenericDaoImpl<Project> implements ProjectDao {

    public List<String> getAllStudentsFio(long id){
        Project project = (Project)getSessionFactory().getCurrentSession().load(Project.class, id);
        List<String> fio = new ArrayList<String>();
        for(Student student:project.getStudents()){
            fio.add(student.getFullName());
        }
        return fio;
    }

    public List<String> getProjectHistory(long studId){
        return getSessionFactory().getCurrentSession().createQuery("select title from ProjectHistory where student.id=:studId").setLong("studId",studId).list();
    }

}
