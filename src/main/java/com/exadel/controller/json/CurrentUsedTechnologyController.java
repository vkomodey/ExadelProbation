package com.exadel.controller.json;


import com.exadel.controller.json.constants.FilterURI;
import com.exadel.controller.json.constants.ProjectURI;
import com.exadel.model.entity.student.Technology;
import com.exadel.service.FilterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Controller
public class CurrentUsedTechnologyController {
	private static Logger logger = LoggerFactory
            .getLogger(CurrentUsedTechnologyController.class);
    @Autowired
    FilterService service;

    @RequestMapping(value = ProjectURI.GET_ALL_CURRENT_PROJECT_USED_TECHNOLOGIES, method = RequestMethod.GET)
    public @ResponseBody List<Technology> returnTechList (@PathVariable("id") String idString) {
        logger.info("Sending feedback list");
        long id=Long.parseLong(idString);
        return new ArrayList<Technology>(service.getCurrentProjUsedTech(id));
    }
}
