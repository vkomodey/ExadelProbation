package com.exadel.controller.json;


import com.exadel.controller.json.constants.ProjectURI;
import com.exadel.model.entity.Project;
import com.exadel.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @RequestMapping(value = ProjectURI.ADD_PROJECT, method = RequestMethod.POST)
    public void addProject(@PathVariable String title){
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
    public @ResponseBody List<String> getAllProjects(@PathVariable long id){
        return projectService.getAllStudentsFio(id);
    }
}
