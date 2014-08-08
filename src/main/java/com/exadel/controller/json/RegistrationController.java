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

import com.exadel.controller.json.constants.GeneralURI;
import com.exadel.controller.json.constants.StudURI;
import com.exadel.model.view.RegistrationView;
import com.exadel.service.RegistrationService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class RegistrationController {
	@Autowired
	RegistrationService service;
	
	private static Logger logger= LoggerFactory.getLogger(RegistrationController.class);

    @RequestMapping(value = StudURI.CREATE_STUDENT, method = RequestMethod.POST)
    public @ResponseBody void registerStudent(@RequestBody String str) {
        logger.info("Start registerStudent.");
        ObjectMapper mapper = new ObjectMapper();
        try {
            RegistrationView view =  mapper.readValue(str,RegistrationView.class);
            logger.info("login:"+view.getLogin());
            service.registerStudent(view);
            logger.info("created");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping(value = GeneralURI.CREATE_ANYONE, method = RequestMethod.POST)
    public void registerAnyone(@RequestBody String str){
    	logger.info("Start registerAnyone.");
        ObjectMapper mapper = new ObjectMapper();
        try {
            RegistrationView view =  mapper.readValue(str,RegistrationView.class);
            logger.info("login:"+view.getLogin());
            service.registerAnyone(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
