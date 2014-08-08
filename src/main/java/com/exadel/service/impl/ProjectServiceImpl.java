package com.exadel.service.impl;

import com.exadel.dao.ProjectDao;
import com.exadel.dao.StudentDao;
import com.exadel.model.entity.Project;
import com.exadel.model.entity.student.Student;
import com.exadel.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProjectServiceImpl implements ProjectService{
    @Autowired
    ProjectDao projectDao;
    @Autowired
    StudentDao studentDao;

    private void lazyTouch(Project project) {
        project.getUsedTechnologies().size();
    }

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

    @Transactional
    public List<Project> getAll(){
        return projectDao.getAll();
    }

    @Transactional
    public List<String> getAllStudentsFio(long projectId){
        return projectDao.getAllStudentsFio(projectId);
    }

    @Transactional
    public Project findById(long projId) {
        Project project = projectDao.find(projId);
        // laaaazy
        lazyTouch(project);
        return project;
    }

    @Transactional
    public void addStudentOnProject(long studId, long projId){
        Student stud = new Student();
        stud =studentDao.find(studId);
        Set<Project> set = stud.getWork().getCurrentProjects();
        set.add(findById(projId));
        projectDao.addStudentOnProject(stud);
    }
}
