package com.exadel.controller.application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @RequestMapping(value = "login/superadmin", method = RequestMethod.GET)
    public ModelAndView JoannaRedirect(ModelAndView model){
        model.setViewName("index");
        return model;
    }

    @RequestMapping(value = "login/curator", method = RequestMethod.GET)
    public String CuratorRedirect(){
        return "redirect:/rest/stud/all";
    }
//
//    @RequestMapping(value = "login/superadmin", method = RequestMethod.GET)
//    public ModelAndView DepartmentRedirect(ModelAndView model){
//        model.setViewName("index");
//        return model;
//    }
}
