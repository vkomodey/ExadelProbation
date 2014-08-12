package com.exadel.service;

import java.util.List;
import java.util.Set;

import com.exadel.model.entity.User;
import com.exadel.model.entity.student.Technology;

public interface FilterService {

	Set<Technology> getCurrentStudUsedTech();

    Set<Technology>  getCurrentProjUsedTech(long projectId);


	List<Integer> getAllStudyEndYears();

	Set<User> getAllUsedCurators();

}
