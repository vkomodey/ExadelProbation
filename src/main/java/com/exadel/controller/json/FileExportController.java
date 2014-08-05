package com.exadel.controller.json;

import java.util.List;
import java.util.logging.Logger;

import com.exadel.service.StudentService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileExportController {

    public static org.slf4j.Logger logger = LoggerFactory
            .getLogger(FeedbackController.class);
    @Autowired
    StudentService service;

    @RequestMapping(value = "/downloadExcel", method = RequestMethod.POST)
    public ModelAndView downloadExcel(@RequestBody List<Long> list) {
        logger.info("Getting filtered list");
        return new ModelAndView("excelView", "list", service.getAll(list));
    }
}
