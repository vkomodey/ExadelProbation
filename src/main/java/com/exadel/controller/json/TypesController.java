package com.exadel.controller.json;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.exadel.controller.json.constants.TypeURI;
import com.exadel.model.constants.StudentStateEnum;
import com.exadel.model.entity.student.Technology;
import com.exadel.service.TypesService;
@RestController
public class TypesController {
	@Autowired
	TypesService typesService;
	static ArrayList<String> states;
	static{
		states=new ArrayList<String>();
    	for(StudentStateEnum sse:StudentStateEnum.values()){
    		states.add(sse.toString());
    	}
	}
	@RequestMapping(value=TypeURI.GET_ALL_TECHNOLOGIES,method=RequestMethod.GET)
	public List<Technology> getTechs(){
		return typesService.getAllTechs();
	}

    @RequestMapping(value = TypeURI.GET_ALL_STATES, method = RequestMethod.GET)
    public List<String> getAllStates(){
        return states;
    }
}
