package com.exadel.util;

import com.exadel.dao.StudentDao;
import com.exadel.dao.impl.StudentDaoImpl;
import com.exadel.model.entity.student.ExadelWork;
import com.exadel.model.entity.student.Technology;
import org.springframework.stereotype.Service;

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

    private String emptyField="empty";

    private String nullCheck(Object o){
        if(o!=null)
            return o.toString();
        return emptyField;
    }

    private String convertTechnologySet(Set<Technology> tech){
        StringBuilder result= new StringBuilder();
        if(tech!=null){
            for(Technology item : tech){
                result.append(item.getName());
                result.append(" ");
            }
            return result.toString();
        }
        return emptyField;
    }

    public void test(Student stud){
        ExadelWork work = new ExadelWork();
        Technology technology = new Technology();
        Set<Technology> set = new HashSet<>();
        work.setBillable(true);
        technology.setName("Java");
        technology.setName("C++");
        technology.setName("C#");
        set.add(technology);
        stud.setWork(work);
        stud.getWork().setCurrentUsedTechnologies(set);
    }

    private void createHeaderRow(HSSFSheet sheet, CellStyle style){
        HSSFRow header = sheet.createRow(0);
        header.createCell(0).setCellValue("Id");
        header.getCell(0).setCellStyle(style);

        header.createCell(1).setCellValue("First Name");
        header.getCell(1).setCellStyle(style);

        header.createCell(2).setCellValue("Second Name");
        header.getCell(2).setCellStyle(style);

        header.createCell(3).setCellValue("Surname");
        header.getCell(3).setCellStyle(style);

        header.createCell(4).setCellValue("English level");
        header.getCell(4).setCellStyle(style);

        header.createCell(5).setCellValue("Faculty");
        header.getCell(5).setCellStyle(style);

        header.createCell(6).setCellValue("Course/Group");
        header.getCell(6).setCellStyle(style);

        header.createCell(7).setCellValue("Graduate year");
        header.getCell(7).setCellStyle(style);

        header.createCell(8).setCellValue("Work start date");
        header.getCell(8).setCellStyle(style);

        header.createCell(9).setCellValue("Current working hours");
        header.getCell(9).setCellStyle(style);

        header.createCell(10).setCellValue("Billable/Not billable");
        header.getCell(10).setCellStyle(style);

        header.createCell(11).setCellValue("Billable start date");
        header.getCell(11).setCellStyle(style);

        header.createCell(12).setCellValue("Project role");
        header.getCell(12).setCellStyle(style);

        header.createCell(13).setCellValue("Current project technology");
        header.getCell(13).setCellStyle(style);
    }

    private void fillTable(HSSFSheet sheet, List<Student> listStud){
        int rowCount = 1;
        for (Student stud : listStud) {
            test(stud);
            HSSFRow aRow = sheet.createRow(rowCount++);
            if(stud!=null){
                aRow.createCell(0).setCellValue(stud.getId());
                aRow.createCell(1).setCellValue(stud.getFirstName());
                aRow.createCell(2).setCellValue(stud.getSecondName());
                aRow.createCell(3).setCellValue(stud.getSurname());
                aRow.createCell(4).setCellValue(nullCheck(stud.getEnglish()));
            }

            if(stud.getStudy()!=null){
                aRow.createCell(5).setCellValue(stud.getStudy().getFaculty());
                aRow.createCell(6).setCellValue(stud.getStudy().getCourse_group());
                aRow.createCell(7).setCellValue(nullCheck(stud.getStudy().getGraduate_year()));
            }

            if(stud.getWork()!=null){
                aRow.createCell(8).setCellValue(nullCheck(stud.getWork().getWorkStartDate()));
                aRow.createCell(9).setCellValue(nullCheck(stud.getWork().getHours_current()));
                aRow.createCell(10).setCellValue(nullCheck(stud.getWork().getIsBillable()));
                aRow.createCell(11).setCellValue(nullCheck((stud.getWork().getBillableStartDate())));
                aRow.createCell(12).setCellValue(nullCheck((stud.getWork().getCurrentProjectRole())));
                aRow.createCell(13).setCellValue(convertTechnologySet(stud.getWork().getCurrentUsedTechnologies()));
            }
        }
    }

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
