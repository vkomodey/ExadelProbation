package com.exadel.service;

import java.util.List;
import java.util.Set;

import com.exadel.model.entity.User;
import com.exadel.model.entity.student.Technology;

public interface FilterService {

	List<String> getAllUniversities();

	Set<Technology> getAllCurrentUsedTechnologies();

	List<String> getAllFaculties();

	List<Long> getAllStudyEndYears();

	List<User> getAllUsedCurators();

}
