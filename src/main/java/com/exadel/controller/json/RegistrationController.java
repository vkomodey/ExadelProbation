package com.exadel.controller.json;


import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exadel.model.entity.student.Student;
import com.exadel.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class RegistrationController {
	@Autowired
	StudentService service;
    static Logger logger= LoggerFactory.getLogger(RegistrationController.class);

    @RequestMapping(value = RestURIConstants.CREATE_STUDENT, method = RequestMethod.POST)
    public @ResponseBody void registerStudent(@RequestBody String str) {
        logger.info("Start createStudent.");
        ObjectMapper mapper = new ObjectMapper();
        try {
            Student student =  mapper.readValue(str,Student.class);
            logger.info("login:"+student.getLogin());
            student.setPassword("11111");
            service.save(student);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
