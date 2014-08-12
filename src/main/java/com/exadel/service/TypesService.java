package com.exadel.service;

import java.util.List;

import com.exadel.model.entity.student.Technology;

public interface TypesService {
	List<Technology> getAllTechs();
    public List<String> getActiveTechs();
}
