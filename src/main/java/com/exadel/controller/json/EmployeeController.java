package com.exadel.controller.json;

import com.exadel.controller.json.constants.EmployeeURI;
import com.exadel.dao.UserDao;
import com.exadel.model.entity.User;
import com.exadel.model.entity.government.Curator;
import com.exadel.model.view.EmployeeView;
import com.exadel.model.view.IdNameSurnamePersonView;
import com.exadel.service.CuratorService;
import com.exadel.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    UserService userService;
    @Autowired
    CuratorService curatorService;
    @RequestMapping(value = EmployeeURI.GET_ALL_EMPLOYEE, method = RequestMethod.GET)
    public @ResponseBody List<EmployeeView> getAllEmployees(){
        return userService.getAllEmployees();
    }
    @RequestMapping(value = EmployeeURI.GET_ALL_CURATOR, method = RequestMethod.GET)
    public @ResponseBody List<IdNameSurnamePersonView> getAllCurators(){
    	List<Curator> curlist=curatorService.getAll();
    	List<IdNameSurnamePersonView> list=new ArrayList<IdNameSurnamePersonView>(curlist.size());
        for(Curator curator:curlist){
        	list.add(new IdNameSurnamePersonView(curator));
        }
        return list;
    }
}
