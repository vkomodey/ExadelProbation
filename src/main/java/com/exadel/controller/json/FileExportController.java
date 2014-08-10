package com.exadel.controller.json;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

    private static final String PATHVARIABLE_NAME = "name";
	private static final String URI_NAME_PATH_SUFFIX = "/{"+PATHVARIABLE_NAME+":.+}";
	private static final String DATEFORMAT = "dd_MM_yy";
	private static final String EXCEL_EXTENSION = ".xls";
	private static final String EXCEL_FILENAME = "Excel_exported";
	private static final String PDF_FILENAME = "PDF_exported";
	private static final String PDF_EXTENSION = ".pdf";
	private static Logger logger = LoggerFactory
            .getLogger(FileExportController.class);
    @Autowired
    StudentService service;

    @RequestMapping(value = ExportURI.DOWNLOAD_EXCEL+URI_NAME_PATH_SUFFIX, method = RequestMethod.GET)
    public ModelAndView getPreparedExcel(HttpSession session,@PathVariable(PATHVARIABLE_NAME) String filename) throws IOException {
        logger.info("Getting Excel file");
        //List<Long> list=JsonUtil.readBelskiyIdObject(str);
        //List<Long> list=mapper.readValue(str, JsonUtil.listOfLongTypeRef);
        @SuppressWarnings("unchecked")
		List<Long> list=(List<Long>) session.getAttribute(filename);
        List<Student> students=service.getAll(list);
        session.removeAttribute(filename);
        return new ModelAndView("excelView", "list", students);
    }
    
    @RequestMapping(value = ExportURI.DOWNLOAD_PDF+URI_NAME_PATH_SUFFIX, method = RequestMethod.GET)
    public ModelAndView getPreparedPDF(HttpSession session,@PathVariable(PATHVARIABLE_NAME) String filename) throws IOException {
        logger.info("Getting PDF file");
        @SuppressWarnings("unchecked")
		List<Long> list=(List<Long>) session.getAttribute(filename);
        List<Student> students=service.getAll(list);
        session.removeAttribute(filename);
        return new ModelAndView("pdfView", "list", students);
    }
    @RequestMapping(value = ExportURI.DOWNLOAD_EXCEL, method = RequestMethod.POST)
    public @ResponseBody String prepareExcel(@RequestBody  String str,ObjectMapper mapper,HttpSession session) throws IOException {
        logger.info("preparing studlist for Excel file");
        //List<Long> list=JsonUtil.readBelskiyIdObject(str);
        List<Long> list=mapper.readValue(str, JsonUtil.listOfLongTypeRef);
        //return new ModelAndView("excelView", "list", service.getAll(list));
        String filename=filenameGen(EXCEL_FILENAME);
        session.setAttribute(filename, list);
        return filename;
    }
    @RequestMapping(value = ExportURI.DOWNLOAD_PDF, method = RequestMethod.POST)
    public @ResponseBody String preparePDF(@RequestBody String str,ObjectMapper mapper,HttpSession session) throws IOException {
        logger.info("preparing studlist for PDF file");
        //List<Long> list=JsonUtil.readBelskiyIdObject(str);
        List<Long> list=mapper.readValue(str, JsonUtil.listOfLongTypeRef);
        String filename = filenameGen(PDF_FILENAME);
        session.setAttribute(filename, list);
        return filename;
        //return new ModelAndView("pdfView", "list", service.getAll(list));
    }

	private String filenameGen(String base) {
		String date=new SimpleDateFormat(DATEFORMAT).format(new Date());
		String ext=base.equals(PDF_FILENAME)?PDF_EXTENSION:EXCEL_EXTENSION;
        String filename=base+"_"+date+ext;
		return filename;
	}
}
