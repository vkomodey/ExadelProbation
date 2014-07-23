package com.exadel.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class RegistrationPopupController {

    public static Logger logger= LoggerFactory.getLogger(RegistrationPopupController.class);

    @RequestMapping(value = RestURIConstants.CREATE_STUDENT, method = RequestMethod.POST)
    public @ResponseBody String getJsonData(@RequestBody String str) {
        logger.info("Start createStudent.");
        System.out.println(str);
        return str;
    }

}
