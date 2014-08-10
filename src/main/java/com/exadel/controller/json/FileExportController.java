package com.exadel.controller.json;

import java.io.IOException;
import java.util.List;

import com.exadel.controller.json.constants.ExportURI;
import com.exadel.service.StudentService;
import com.exadel.util.JsonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileExportController {

    private static Logger logger = LoggerFactory
            .getLogger(FileExportController.class);
    @Autowired
    StudentService service;

    @RequestMapping(value = ExportURI.DOWNLOAD_EXCEL, method = RequestMethod.GET)
    public ModelAndView downloadExcel(@RequestParam("ids")  String str,ObjectMapper mapper) throws IOException {
        logger.info("Getting Excel file");
        List<Long> list=JsonUtil.readBelskiyIdObject(str);
        //List<Long> list=mapper.readValue(str, JsonUtil.listOfLongTypeRef);
        return new ModelAndView("excelView", "list", service.getAll(list));
    }

    @RequestMapping(value = ExportURI.DOWNLOAD_PDF, method = RequestMethod.GET)
    public ModelAndView downloadPDF(@RequestParam("ids") String str,ObjectMapper mapper) throws IOException {
        logger.info("Getting pdf file");
        List<Long> list=JsonUtil.readBelskiyIdObject(str);
        //List<Long> list=mapper.readValue(str, JsonUtil.listOfLongTypeRef);
        return new ModelAndView("pdfView", "list", service.getAll(list));
    }
}
