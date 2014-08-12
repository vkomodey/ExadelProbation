package com.exadel.service;

import com.exadel.model.entity.Project;

import java.util.List;

public interface ProjectService {
    public void deleteProjectById(long id);

    public void addProject(String title);

    public void addStudentOnProject(long studId, long projId);

    public void removeStudentFromProject(long studId, long projId);

    public List<Project> getAll();

    public List<String> getAllStudentsFio(long projectId);

    public List<String> getProjectHistory(long studId);
}
