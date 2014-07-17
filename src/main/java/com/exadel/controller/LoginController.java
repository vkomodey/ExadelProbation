package com.exadel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView listRedirect(ModelAndView model){
        model.addObject("message", "zhora");
        model.setViewName("list");
        return model;
    }
}
