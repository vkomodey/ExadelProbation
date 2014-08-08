package com.exadel.controller.json;


import com.exadel.controller.json.constants.ProjectURI;
import com.exadel.model.entity.Project;
import com.exadel.model.entity.student.Technology;
import com.exadel.service.FilterService;
import com.exadel.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProjectController {
    @Autowired
    ProjectService projectService;
    @Autowired
    FilterService service;

    @RequestMapping(value = ProjectURI.ADD_PROJECT, method = RequestMethod.POST)
    public void addProject(@RequestBody String title){
        projectService.addProject(title);
    }

    @RequestMapping(value = ProjectURI.REMOVE_PROJECT, method = RequestMethod.POST)
    public void deleteProject(@PathVariable long id){
        projectService.deleteProjectById(id);
    }

    @RequestMapping(value = ProjectURI.GET_ALL_PROJECTS, method = RequestMethod.GET)
    public @ResponseBody List<Project> getAllProjects(){
        return projectService.getAll();
    }

    @RequestMapping(value = ProjectURI.GET_ALL_STUDENTS, method = RequestMethod.GET)
    public @ResponseBody List<String> getAllStudents(@PathVariable long id){
        return projectService.getAllStudentsFio(id);
    }

    @RequestMapping(value = ProjectURI.GET_ALL_CURRENT_PROJECT_USED_TECHNOLOGIES, method = RequestMethod.GET)
    public @ResponseBody List<Technology> returnTechList (@PathVariable("id") String idString) {
        long id=Long.parseLong(idString);
        return new ArrayList<Technology>(service.getCurrentProjUsedTech(id));
    }

    @RequestMapping(value = ProjectURI.ADD_STUDENT_ON_PROJECT, method = RequestMethod.POST)
    public void addStudentOnProject(@PathVariable("stud_id") String studId, @PathVariable("id") String projId){
        long stiId=Long.parseLong(studId);
        long prId=Long.parseLong(projId);
        projectService.addStudentOnProject(stiId,prId);
    }
}
