package com.exadel.controller.json;


import com.exadel.controller.json.constants.ProjectURI;
import com.exadel.model.entity.Project;
import com.exadel.model.entity.student.Technology;
import com.exadel.service.FilterService;
import com.exadel.service.ProjectService;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProjectController {
    @Autowired
    ProjectService projectService;
    @Autowired
    FilterService service;
    private static Logger logger=LoggerFactory.getLogger(ProjectController.class);
    
    @RequestMapping(value = ProjectURI.ADD_PROJECT, method = RequestMethod.POST)
    public @ResponseBody void addProject(@RequestBody String title){
        projectService.addProject(title);
    }

    @RequestMapping(value = ProjectURI.REMOVE_PROJECT, method = RequestMethod.POST)
    public @ResponseBody void deleteProject(@PathVariable long id){
        projectService.deleteProjectById(id);
    }

    @RequestMapping(value = ProjectURI.GET_ALL_PROJECTS, method = RequestMethod.GET)
    public @ResponseBody List<Project> getAllProjects(){
        return projectService.getAll();
    }

    @RequestMapping(value = ProjectURI.GET_ALL_STUDENTS, method = RequestMethod.GET)
    public @ResponseBody String getAllStudents(@PathVariable("id") long id,ObjectMapper om) throws IOException{
    	StringWriter sw=new StringWriter();
    	JsonGenerator jg=om.getFactory().createGenerator(sw);
    	jg.writeStartArray();
    	for(String name:projectService.getAllStudentsFio(id)){
    		jg.writeStartObject();
    		jg.writeStringField("name",name);
    		jg.writeEndObject();
    	}
    	jg.writeEndArray();
    	jg.close();
    	logger.info("json created in getAllStudents() for project "+String.valueOf(id)+":"+sw.toString());
        return sw.toString();
    }

    @RequestMapping(value = ProjectURI.GET_ALL_CURRENT_PROJECT_USED_TECHNOLOGIES, method = RequestMethod.GET)
    public @ResponseBody List<Technology> returnTechList (@PathVariable("id") String idString) {
        long id=Long.parseLong(idString);
        return new ArrayList<Technology>(service.getCurrentProjUsedTech(id));
    }

    @RequestMapping(value = ProjectURI.ADD_STUDENT_ON_PROJECT, method = RequestMethod.POST)
    public @ResponseBody void addStudentOnProject(@PathVariable("stud_id") String studId, @PathVariable("id") String projId){
        long stiId=Long.parseLong(studId);
        long prId=Long.parseLong(projId);
        projectService.addStudentOnProject(stiId,prId);
    }

    @RequestMapping(value = ProjectURI.REMOVE_STUDENT_FROM_PROJECT, method = RequestMethod.POST)
    public @ResponseBody void removeStudentFromProject(@PathVariable("stud_id") String studId, @PathVariable("id") String projId){
        long stiId=Long.parseLong(studId);
        long prId=Long.parseLong(projId);
        projectService.removeStudentFromProject(stiId,prId);
    }
}
