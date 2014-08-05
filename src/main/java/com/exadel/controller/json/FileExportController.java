package com.exadel.controller.json;

import java.util.ArrayList;
import java.util.List;

import com.exadel.service.StudentService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileExportController {

    public static org.slf4j.Logger logger = LoggerFactory
            .getLogger(FeedbackController.class);
    @Autowired
    StudentService service;

    @RequestMapping(value = RestURIConstants.DOWNLOAD_EXCEL, method = RequestMethod.POST)
    public ModelAndView downloadExcel(@RequestBody List<Long> list) {
        logger.info("Getting Excel file");
        return new ModelAndView("excelView", "list", service.getAll(list));
    }

    @RequestMapping(value = RestURIConstants.DOWNLOAD_PDF, method = RequestMethod.POST)
    public ModelAndView downloadPDF(@RequestBody List<Long> list) {
        logger.info("Getting pdf file");
        return new ModelAndView("pdfView", "list", service.getAll(list));
    }

/*    @RequestMapping(value = RestURIConstants.DOWNLOAD_PDF, method = RequestMethod.GET)
    public ModelAndView downloadPDF() {
        logger.info("Getting pdf file");
        List<Long> list = new ArrayList<>();
        list.add((long)19);
        list.add((long)20);
        return new ModelAndView("pdfView", "list", service.getAll(list));
    }



    @RequestMapping(value = RestURIConstants.DOWNLOAD_EXCEL, method = RequestMethod.GET)
    public ModelAndView downloadExcel() {
        logger.info("Getting filtered list");
        List<Long> list = new ArrayList<>();
        list.add((long)19);
        list.add((long)20);
        return new ModelAndView("excelView", "list", service.getAll(list));
    }*/
}
