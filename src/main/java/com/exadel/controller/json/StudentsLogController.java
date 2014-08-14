package com.exadel.controller.json;


import com.exadel.controller.json.constants.StudURI;
import com.exadel.model.view.StudentStateView;
import com.exadel.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StudentsLogController {

    private static Logger logger = LoggerFactory
            .getLogger(StudentsLogController.class);
    @Autowired
    StudentService service;

    @RequestMapping(value= StudURI.GET_STUDENTS_LOG,method= RequestMethod.GET)
    public @ResponseBody List<StudentStateView> getLog(@PathVariable("id") String id){
        logger.info("Start getting log");
        long studId = Long.parseLong(id);
        return service.getStudentStateList(studId);
    }
}