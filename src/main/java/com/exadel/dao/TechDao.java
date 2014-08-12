package com.exadel.dao;

import java.util.List;
import java.util.Set;

import com.exadel.model.entity.student.Technology;


public interface TechDao extends GenericDao<Technology>{
	public Set<String> getNames();
	public Technology find(String name);
	public List<String> getActiveNames();
}
