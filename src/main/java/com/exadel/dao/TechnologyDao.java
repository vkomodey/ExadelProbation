package com.exadel.dao;

import java.util.List;

import com.exadel.model.entity.student.Technology;

public interface TechnologyDao extends GenericDao<Technology>{

	List<Technology> getAllCurrentUsedByStudents();
	
}
