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
        return getSessionFactory().getCurrentSession().createQuery("from Project ").list();
    }

    public void deleteProjectById(long id){
        Project project = (Project)getSessionFactory().getCurrentSession().get(Project.class, id);
        getSessionFactory().getCurrentSession().delete(project);
    }
}
