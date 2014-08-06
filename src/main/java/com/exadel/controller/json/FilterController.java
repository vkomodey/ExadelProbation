package com.exadel.controller.json;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.exadel.controller.json.constants.FilterURI;
import com.exadel.model.entity.User;
import com.exadel.model.entity.student.Technology;
import com.exadel.model.entity.view.IdNameSurnamePersonView;
import com.exadel.service.FilterService;

@RestController
public class FilterController {
	@Autowired
	FilterService service;

	@RequestMapping(value=FilterURI.GET_ALL_UNIVERSITIES,method=RequestMethod.GET)
	public List<String> getAllUniversities(){
		return service.getAllUniversities();
    }
	@RequestMapping(value=FilterURI.GET_ALL_FACULTIES,method=RequestMethod.GET)
	public List<String> getAllFaculties(){
		return service.getAllFaculties();
    }
	@RequestMapping(value=FilterURI.GET_ALL_STUDY_END_YEARS,method=RequestMethod.GET)
	public List<Long> getAllStudyEndYears(){
		return service.getAllStudyEndYears();
    }
	@RequestMapping(value=FilterURI.GET_ALL_USED_CURATORS,method=RequestMethod.GET)
	public List<IdNameSurnamePersonView> getAllUsedCurators(){
		List<IdNameSurnamePersonView> list=new ArrayList<>();
		for(User u:service.getAllUsedCurators()){
			list.add(new IdNameSurnamePersonView(u));
		}
		return list;
    }
	@RequestMapping(value=FilterURI.GET_ALL_CURRENT_USED_TECHNOLOGIES,method=RequestMethod.GET)
	public Set<String> getAllCurrentUsedTechnologies(){
		Set<Technology> techs=service.getAllCurrentUsedTechnologies();
		Set<String> technames=new HashSet<>();
		for(Technology tech:techs){
			technames.add(tech.getName());
		}
		return technames;
    }
}
