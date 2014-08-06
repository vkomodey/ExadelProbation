package com.exadel.dao.impl;

import com.exadel.dao.ProjectDao;
import com.exadel.model.entity.Project;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ProjectDaoImpl extends GenericDaoImpl<Project> implements ProjectDao {
    public Project find(long id){
        return null;
    }

    public List<Project> getAll(){
        return null;
    }

    public void addProject(String title){
//        getSessionFactory().getCurrentSession().save(Project.class,)
    }

    public void deleteProjectById(long id){

    }
}
