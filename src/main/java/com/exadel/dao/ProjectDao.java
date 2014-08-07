package com.exadel.dao;

import com.exadel.model.entity.Project;

public interface ProjectDao extends GenericDao<Project> {
    public void deleteProjectById(long id);
}
