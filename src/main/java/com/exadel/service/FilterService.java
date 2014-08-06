package com.exadel.service;

import java.util.List;
import java.util.Set;

import com.exadel.model.entity.User;

public interface FilterService {

	List<String> getAllUniversities();

	Set<String> getAllCurrentUsedTechnologies();

	List<String> getAllFaculties();

	List<Long> getAllStudyEndYears();

	List<User> getAllUsedCurators();

}
