package com.exadel.dao;

import com.exadel.model.entity.Project;
import java.util.List;

public interface ProjectDao extends GenericDao<Project> {

    public List<String> getAllStudentsFio(long projectId);

    public List<String> getProjectHistory(long studId);

}
