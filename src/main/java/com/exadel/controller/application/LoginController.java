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
    @RequestMapping(value = "login/admin", method = RequestMethod.GET)
    public ModelAndView AdminRedirect(ModelAndView model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User)authentication.getPrincipal();
        System.out.println(user.getPassword());
        System.out.println(user.getAuthorities());
        System.out.printf("azazazaa");
        System.out.println("sssssssss");
        model.setViewName("index");
        return model;
    }
}
