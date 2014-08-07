package com.exadel.service;

import com.exadel.model.entity.Project;

import java.util.List;

public interface ProjectService {
    public void deleteProjectById(long id);

    public void addProject(String title);

    public List<Project> getAll();
}
