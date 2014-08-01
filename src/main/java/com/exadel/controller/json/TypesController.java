package com.exadel.controller.json;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.exadel.model.entity.student.SkillType;
import com.exadel.service.TypesService;
@RestController
public class TypesController {
	@Autowired
	TypesService typesService;
	@RequestMapping(value=RestURIConstants.GET_ALL_SKILLTYPE,method=RequestMethod.GET)
	public List<SkillType> getSkillTypes(){
		return typesService.getAllSkillTypes();
	}
}
