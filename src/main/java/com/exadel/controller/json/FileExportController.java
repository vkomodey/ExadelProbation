package com.exadel.controller.json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.exadel.controller.json.constants.ExportURI;
import com.exadel.model.entity.view.FileExportView;
import com.exadel.service.StudentService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

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

    @RequestMapping(value = ExportURI.DOWNLOAD_EXCEL, method = RequestMethod.GET)
    public @ResponseBody ModelAndView downloadExcel(@RequestParam("ids")  String str) throws IOException {
        logger.info("Getting Excel file");
        ObjectMapper mapper = new ObjectMapper();
        List<FileExportView> list = mapper.readValue(str, new TypeReference<ArrayList<FileExportView>>() {});
        return new ModelAndView("excelView", "list", service.getAll(list));
    }

    @RequestMapping(value = ExportURI.DOWNLOAD_PDF, method = RequestMethod.GET)
    public @ResponseBody ModelAndView downloadPDF(@RequestParam("ids") String str) throws IOException {
        logger.info("Getting pdf file");
        ObjectMapper mapper = new ObjectMapper();
        List<FileExportView> list = mapper.readValue(str, new TypeReference<ArrayList<FileExportView>>() {});
        return new ModelAndView("pdfView", "list", service.getAll(list));
    }
}
