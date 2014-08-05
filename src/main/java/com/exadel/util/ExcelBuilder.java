package com.exadel.util;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    public void createHeaderRow(HSSFSheet sheet, CellStyle style){
        HSSFRow header = sheet.createRow(0);
        header.createCell(0).setCellValue("Id");
        header.getCell(0).setCellStyle(style);

        header.createCell(1).setCellValue("First Name");
        header.getCell(1).setCellStyle(style);

        header.createCell(2).setCellValue("Second Name");
        header.getCell(2).setCellStyle(style);

        header.createCell(3).setCellValue("Surname");
        header.getCell(3).setCellStyle(style);

        header.createCell(4).setCellValue("Work start date");
        header.getCell(4).setCellStyle(style);

        header.createCell(5).setCellValue("Faculty");
        header.getCell(5).setCellStyle(style);

        header.createCell(6).setCellValue("Course/Group");
        header.getCell(6).setCellStyle(style);

        header.createCell(7).setCellValue("Graduate year");
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

        header.createCell(13).setCellValue("English level");
        header.getCell(13).setCellStyle(style);


    }

    public void fillTable(HSSFSheet sheet, List<Student> listStud){
        int rowCount = 1;
        for (Student stud : listStud) {
            HSSFRow aRow = sheet.createRow(rowCount++);
            aRow.createCell(0).setCellValue(stud.getId());
            aRow.createCell(1).setCellValue(stud.getFirstName());
            aRow.createCell(2).setCellValue(stud.getSecondName());
            aRow.createCell(3).setCellValue(stud.getSurname());
            aRow.createCell(4).setCellValue(stud.getWork().getWorkStartDate());
            aRow.createCell(5).setCellValue(stud.getStudy().getFaculty());
            aRow.createCell(6).setCellValue(stud.getStudy().getCourse_group());
            aRow.createCell(7).setCellValue(stud.getStudy().getGraduate_year());
            aRow.createCell(8).setCellValue(stud.getWork().getHours_current());
            aRow.createCell(9).setCellValue(stud.getWork().isBillable());
            aRow.createCell(10).setCellValue(stud.getWork().getBillableStartDate());
            aRow.createCell(11).setCellValue(stud.getWork().getCurrentProjectRole().toString());
            aRow.createCell(12).setCellValue("ДОПИСАТЬ!!!!!!!!!!!");
            aRow.createCell(13).setCellValue(stud.getEnglish().toString());
        }
    }

    @Override
    protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook,
                                      HttpServletRequest request, HttpServletResponse response) throws Exception {
        // get data model which is passed by the Spring container
        List<Student> listStud = (List<Student>) model.get("list");

        // create a new Excel sheet
        HSSFSheet sheet = workbook.createSheet("Java Books");
        sheet.setDefaultColumnWidth(30);

        // create style for header cells
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Arial");
        style.setFillForegroundColor(HSSFColor.BLUE.index);
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setColor(HSSFColor.WHITE.index);
        style.setFont(font);

        // create header row
        createHeaderRow(sheet,style);

        // create data rows
        fillTable(sheet,listStud);
    }
}
