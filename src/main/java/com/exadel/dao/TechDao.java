package com.exadel.dao;

import java.util.List;
import java.util.Set;

import com.exadel.model.entity.student.Technology;


public interface TechDao extends GenericNamedDao<Technology>{
	public Set<String> getNames();
	public Technology find(String name);
	List<Technology> getAllCurrentUsedByStudents();
	List<Technology> getAllCurrentUsedByProjects(long projectId);
}
