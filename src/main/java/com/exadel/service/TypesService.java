package com.exadel.service;

import java.util.List;

import com.exadel.model.entity.student.Faculty;
import com.exadel.model.entity.student.Technology;
import com.exadel.model.entity.student.University;

public interface TypesService {
	public List<Technology> getAllTechs();
    public List<String> getActiveTechs();
    public List<University> getAllUniversities();
    public List<String> getActiveUniversities();
    public List<Faculty> getAllFaculties();
    public List<String> getActiveFaculties();
    //public List<Faculty> getAllFaculties();
    //public List<String> getActiveFaculties();
    public void push(University university);
    public void push(Faculty faculty);
    //public void push(University university);
	public void removeUniversity(Long id);
	public void removeFaculty(Long id);
	public void push(Technology technology);
	public void removeTechnology(Long id);
}
