package com.exadel.controller.application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @RequestMapping(value = "login/admin", method = RequestMethod.POST)
    public ModelAndView AdminRedirect(ModelAndView model){
        model.setViewName("index");
        return model;
    }
}
