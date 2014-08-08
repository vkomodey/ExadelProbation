package com.exadel.dao.impl;

import com.exadel.dao.ProjectDao;
import com.exadel.model.entity.Project;
import com.exadel.model.entity.student.Student;
import com.exadel.model.entity.student.Technology;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProjectDaoImpl extends GenericDaoImpl<Project> implements ProjectDao {
    public Project find(long id){
        return null;
    }

    @SuppressWarnings("unchecked")
	public List<Project> getAll(){
        List<Project> list = getSessionFactory().getCurrentSession().createQuery("from Project").list();
        return list;
    }
    public void lazyTouchProject(Project project){
        for(Student student:project.getStudents()){
            student.getId();
        }
        for(Technology technology:project.getUsedTechnologies()){
            technology.getId();
        }
    }

    public void deleteProjectById(long id){
        Project project = (Project)getSessionFactory().getCurrentSession().get(Project.class, id);
        getSessionFactory().getCurrentSession().delete(project);
    }

    public List<String> getAllStudentsFio(long projectId){
        Project project = (Project)getSessionFactory().getCurrentSession().get(Project.class, projectId);
        List<String> fio = new ArrayList<String>();
        for(Student student:project.getStudents()){
            fio.add(student.getFullName());
        }
        return fio;
    }
}
