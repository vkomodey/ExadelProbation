package com.exadel.controller.json;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.exadel.model.entity.view.FeedbackView;
import com.exadel.model.entity.view.FileExportView;
import com.exadel.service.StudentService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileExportController {

    public static org.slf4j.Logger logger = LoggerFactory
            .getLogger(FeedbackController.class);
    @Autowired
    StudentService service;

/*    @RequestMapping(value = RestURIConstants.DOWNLOAD_EXCEL, method = RequestMethod.GET)
    public ModelAndView downloadExcel() {
        logger.info("Getting Excel file");
        ArrayList<Long> list = new ArrayList<Long>();
        list.add((long)19);
        list.add((long)20);
        return new ModelAndView("excelView", "list", service.getAll(list));
    }*/

    @RequestMapping(value = RestURIConstants.DOWNLOAD_EXCEL, method = RequestMethod.GET)
    public @ResponseBody ModelAndView downloadExcel(@RequestParam("ids")  String str) {
        logger.info("Getting Excel file");
        try{
            ObjectMapper mapper = new ObjectMapper();
            List<FileExportView> list = mapper.readValue(str, new TypeReference<ArrayList<FileExportView>>() {});
            return new ModelAndView("excelView", "list", service.getAll(list));
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /*@RequestMapping(value = RestURIConstants.DOWNLOAD_PDF, method = RequestMethod.POST)
    public ModelAndView downloadPDF(@RequestBody String str) {
        logger.info("Getting pdf file");
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<FileExportView> list = mapper.readValue(str, new TypeReference<ArrayList<FileExportView>>() {});
            return new ModelAndView("pdfView", "list", service.getAll(list));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }*/
}
