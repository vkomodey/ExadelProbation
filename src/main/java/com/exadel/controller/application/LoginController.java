package com.exadel.controller.application;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
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

    @RequestMapping(value = "login/", method = RequestMethod.GET)
    public ModelAndView FeedbackerRedirect(ModelAndView model){
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        model.setViewName("index");
        return model;
    }

    @RequestMapping(value = "login/superadmin", method = RequestMethod.GET)
    public ModelAndView DepartmentRedirect(ModelAndView model){
        model.setViewName("index");
        return model;
    }
}
