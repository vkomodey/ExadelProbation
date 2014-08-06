package com.exadel.dao;

import com.exadel.model.entity.Project;

public interface ProjectDao extends GenericDao<Project> {
    public void addProject(String title);
    public void deleteProjectById(long id);
}
