package com.exadel.controller;


import com.exadel.model.entity.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
public class RegistrationController {

    public static Logger logger= LoggerFactory.getLogger(RegistrationController.class);

    @RequestMapping(value = RestURIConstants.CREATE_STUDENT, method = RequestMethod.POST)
    public @ResponseBody void getJsonData(@RequestBody String str) {
        logger.info("Start createStudent.");
        ObjectMapper mapper = new ObjectMapper();
        try {
            Student student =  mapper.readValue(str,Student.class);
            logger.info(student.toString());
            student.setPassword("11111");
            // дальше типа сохраняем

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
