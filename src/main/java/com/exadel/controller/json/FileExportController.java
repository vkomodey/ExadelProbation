package com.exadel.controller.json;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.exadel.controller.json.constants.ExportURI;
import com.exadel.model.entity.student.Student;
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

    private static final String EXCELLIST_ATTRIBUTE = "excellist";
	private static final String PDFLIST_ATTRIBUTE = "pdflist";
	private static Logger logger = LoggerFactory
            .getLogger(FileExportController.class);
    @Autowired
    StudentService service;

    @RequestMapping(value = ExportURI.DOWNLOAD_EXCEL, method = RequestMethod.GET)
    public ModelAndView getPreparedExcel(HttpSession session) throws IOException {
        logger.info("Getting Excel file");
        //List<Long> list=JsonUtil.readBelskiyIdObject(str);
        //List<Long> list=mapper.readValue(str, JsonUtil.listOfLongTypeRef);
        @SuppressWarnings("unchecked")
		List<Long> list=(List<Long>) session.getAttribute(EXCELLIST_ATTRIBUTE);
        List<Student> students=service.getAll(list);
        session.removeAttribute(EXCELLIST_ATTRIBUTE);
        return new ModelAndView("excelView", "list", students);
    }
    
    @RequestMapping(value = ExportURI.DOWNLOAD_PDF, method = RequestMethod.GET)
    public ModelAndView getPreparedPDF(HttpSession session) throws IOException {
        logger.info("Getting PDF file");
        @SuppressWarnings("unchecked")
		List<Long> list=(List<Long>) session.getAttribute(PDFLIST_ATTRIBUTE);
        List<Student> students=service.getAll(list);
        session.removeAttribute(PDFLIST_ATTRIBUTE);
        return new ModelAndView("pdfView", "list", students);
    }
    @RequestMapping(value = ExportURI.DOWNLOAD_EXCEL, method = RequestMethod.POST)
    public @ResponseBody void prepareExcel(@RequestBody  String str,ObjectMapper mapper,HttpSession session) throws IOException {
        logger.info("preparing studlist for Excel file");
        //List<Long> list=JsonUtil.readBelskiyIdObject(str);
        List<Long> list=mapper.readValue(str, JsonUtil.listOfLongTypeRef);
        session.setAttribute(EXCELLIST_ATTRIBUTE, list);
        //return new ModelAndView("excelView", "list", service.getAll(list));
        
    }
    @RequestMapping(value = ExportURI.DOWNLOAD_PDF, method = RequestMethod.POST)
    public @ResponseBody void preparePDF(@RequestBody String str,ObjectMapper mapper,HttpSession session) throws IOException {
        logger.info("preparing studlist for PDF file");
        //List<Long> list=JsonUtil.readBelskiyIdObject(str);
        List<Long> list=mapper.readValue(str, JsonUtil.listOfLongTypeRef);
        session.setAttribute(PDFLIST_ATTRIBUTE, list);
        //return new ModelAndView("pdfView", "list", service.getAll(list));
    }
}
