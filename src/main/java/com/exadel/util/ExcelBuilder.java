package com.exadel.util;

import com.exadel.model.entity.student.Technology;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.exadel.model.entity.student.Student;


@Service
public class ExcelBuilder extends AbstractExcelView {

    private void createHeaderRow(HSSFSheet sheet, CellStyle style){
        HSSFRow header = sheet.createRow(0);
        header.createCell(0).setCellValue("First Name");
        header.getCell(0).setCellStyle(style);

        header.createCell(1).setCellValue("Second Name");
        header.getCell(1).setCellStyle(style);

        header.createCell(2).setCellValue("Surname");
        header.getCell(2).setCellStyle(style);

        header.createCell(3).setCellValue("English level");
        header.getCell(3).setCellStyle(style);

        header.createCell(4).setCellValue("Faculty");
        header.getCell(4).setCellStyle(style);

        header.createCell(5).setCellValue("Course/Group");
        header.getCell(5).setCellStyle(style);

        header.createCell(6).setCellValue("Graduate year");
        header.getCell(6).setCellStyle(style);

        header.createCell(7).setCellValue("Work start date");
        header.getCell(7).setCellStyle(style);

        header.createCell(8).setCellValue("Current working hours");
        header.getCell(8).setCellStyle(style);

        header.createCell(9).setCellValue("Billable/Not billable");
        header.getCell(9).setCellStyle(style);

        header.createCell(10).setCellValue("Billable start date");
        header.getCell(10).setCellStyle(style);

        header.createCell(11).setCellValue("Project role");
        header.getCell(11).setCellStyle(style);

        header.createCell(12).setCellValue("Current project technology");
        header.getCell(12).setCellStyle(style);
    }

    private void fillTable(HSSFSheet sheet, List<Student> listStud){
        int rowCount = 1;
        for (Student stud : listStud) {
            HSSFRow aRow = sheet.createRow(rowCount++);
            if(stud!=null){
                aRow.createCell(0).setCellValue(BuilderUtil.nullCheck(stud.getFirstName()));
                aRow.createCell(1).setCellValue(BuilderUtil.nullCheck(stud.getSecondName()));
                aRow.createCell(2).setCellValue(BuilderUtil.nullCheck(stud.getSurname()));
                aRow.createCell(3).setCellValue(BuilderUtil.nullCheck(stud.getEnglish()));
            }

            if(stud.getStudy()!=null){
                aRow.createCell(4).setCellValue(BuilderUtil.nullCheck(stud.getStudy().getFaculty()));
                aRow.createCell(5).setCellValue(BuilderUtil.nullCheck(stud.getStudy().getCourse_group()));
                aRow.createCell(6).setCellValue(BuilderUtil.nullCheck(stud.getStudy().getGraduate_year()));
            }

            if(stud.getWork()!=null){
                aRow.createCell(7).setCellValue(BuilderUtil.dateConvert(stud));
                aRow.createCell(8).setCellValue(BuilderUtil.nullCheck(stud.getWork().getHours_current()));
                aRow.createCell(9).setCellValue(BuilderUtil.nullCheck(stud.getWork().getIsBillable()));
                aRow.createCell(10).setCellValue(BuilderUtil.nullCheck((stud.getWork().getBillableStartDate())));
                aRow.createCell(11).setCellValue(BuilderUtil.nullCheck((stud.getWork().getCurrentProjectRole())));
                aRow.createCell(12).setCellValue(BuilderUtil.convertTechnologySet(stud.getWork().getCurrentUsedTechnologies()));
            }
        }
    }

    @SuppressWarnings("unchecked")
	@Override
    protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook,
                                      HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Student> listStud = (List<Student>) model.get("list");

        HSSFSheet sheet = workbook.createSheet("Java Books");
        sheet.setDefaultColumnWidth(30);

        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Arial");
        style.setFillForegroundColor(HSSFColor.BLUE.index);
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setColor(HSSFColor.WHITE.index);
        style.setFont(font);

        createHeaderRow(sheet,style);

        fillTable(sheet,listStud);
    }
}
