package com.exadel.service.impl;

import com.exadel.dao.ProjectDao;
import com.exadel.model.entity.Project;
import com.exadel.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectServiceImpl implements ProjectService{
    @Autowired
    ProjectDao projectDao;
    @Transactional
    public void addProject(String title){
        Project project = new Project();
        project.setTitle(title);
        projectDao.save(project);
    }
    @Transactional
    public void deleteProjectById(long id){
        projectDao.deleteProjectById(id);
    }
}
