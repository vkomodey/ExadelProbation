package com.exadel.controller.json;


import com.exadel.controller.json.constants.FilterURI;
import com.exadel.model.entity.student.Technology;
import com.exadel.service.FilterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Controller
public class CurrentUsedTechnologyController {
    public static Logger logger = LoggerFactory
            .getLogger(FeedbackController.class);
    @Autowired
    FilterService service;

    @RequestMapping(value = FilterURI.GET_ALL_CURRENT_PROJECT_USED_TECHNOLOGIES, method = RequestMethod.GET)
    public @ResponseBody List<Technology> returnTechList () {
        logger.info("Sending feedback list");
        return new ArrayList<Technology>(service.getCurrentProjUsedTech());
    }
}
