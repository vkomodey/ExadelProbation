package com.exadel.util;


import com.exadel.model.entity.student.Student;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.List;

@Service
public class PDFBuilder extends AbstractPdfView {

    static final int tableSize=13;
    static final int studyNumber=3;
    static final int workNumber=6;

    private void fillEmpty(Table table,int number) throws BadElementException {
        for(int i=0; i<number; i++)
            table.addCell(BuilderUtil.emptyField);
    }

    private void addHeader(Table table) throws BadElementException {
        table.addCell("First Name");
        table.addCell("Second Name");
        table.addCell("Surname");
        table.addCell("English level");


        table.addCell("Faculty");
        table.addCell("Course/Group");
        table.addCell("Graduate year");

        table.addCell("Work start date");
        table.addCell("Current working hours");
        table.addCell("Billable/Not billable");
        table.addCell("Billable start date");
        table.addCell("Project role");
        table.addCell("Current project technology");
    }

    private void fillTable(Table table,List<Student> listStud) throws BadElementException {
        for (Student stud : listStud) {

            table.addCell(BuilderUtil.nullCheck(stud.getFirstName()));
            table.addCell(BuilderUtil.nullCheck(stud.getMiddleName()));
            table.addCell(BuilderUtil.nullCheck(stud.getSurname()));
            table.addCell(BuilderUtil.nullCheck(stud.getEnglish()));

            if(stud.getStudy()!=null){
                table.addCell(BuilderUtil.nullCheck(stud.getStudy().getFaculty()));
                table.addCell(BuilderUtil.nullCheck(stud.getStudy().getCourse_group()));
                table.addCell(BuilderUtil.nullCheck(stud.getStudy().getGraduate_year()));
            }else{
                fillEmpty(table,studyNumber);
            }

            if(stud.getWork()!=null){
                table.addCell(BuilderUtil.dateConvert(stud));
                table.addCell(BuilderUtil.nullCheck(stud.getWork().getHours_current()));
                table.addCell(BuilderUtil.nullCheck(stud.getWork().getIsBillable()));
                table.addCell(BuilderUtil.nullCheck(stud.getWork().getBillableStartDate()));
                table.addCell(BuilderUtil.nullCheck(stud.getWork().getCurrentProjectRole()));
                table.addCell(BuilderUtil.convertTechnologySet(stud.getWork().getCurrentUsedTechnologies()));
            }else{
                fillEmpty(table,workNumber);
            }
        }
    }

    @Override
    protected void buildPdfDocument(Map model, Document document,
                                    PdfWriter writer, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {

        List<Student> listStud = (List<Student>) model.get("list");
        document.setPageSize(PageSize.A2.rotate());
        document.open();
        document.newPage();
        Table table = new Table(tableSize);
        table.setPadding(5);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        table.getDefaultCell().setVerticalAlignment(Element.ALIGN_CENTER);
        addHeader(table);
        fillTable(table,listStud);
        document.add(table);
	System.out.println("2222");
    }
}
