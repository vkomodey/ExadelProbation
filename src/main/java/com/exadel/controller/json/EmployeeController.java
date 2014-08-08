package com.exadel.controller.json;

import com.exadel.controller.json.constants.EmployeeURI;
import com.exadel.dao.UserDao;
import com.exadel.model.entity.User;
import com.exadel.model.view.EmployeeView;
import com.exadel.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    UserService userService;
    @RequestMapping(value = EmployeeURI.GET_ALL_EMPLOYEE, method = RequestMethod.GET)
    public @ResponseBody List<EmployeeView> getAllEmployees(){
        return userService.getAllEmployees();
    }
}
