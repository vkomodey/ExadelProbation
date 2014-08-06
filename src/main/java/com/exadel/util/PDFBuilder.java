package com.exadel.util;


import com.exadel.model.entity.student.Student;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Service
public class PDFBuilder extends AbstractPdfView {

    static final int tableSize=14;
    static final int studyNumber=3;
    static final int workNumber=5;
    private String emptyField="-";

    private String nullCheck(Object o){
        if(o!=null)
            return o.toString();
        return emptyField;
    }

    private void fillEmpty(Table table,int number) throws BadElementException {
        for(int i=0; i<number; i++)
            table.addCell("-");
    }

    private void addHeader(Table table) throws BadElementException {
        table.addCell("Id");
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
            if(stud!=null){
                table.addCell(stud.getId().toString());
                table.addCell(stud.getFirstName());
                table.addCell(stud.getSecondName());
                table.addCell(stud.getSurname());
                table.addCell(nullCheck(stud.getEnglish()));
            }

            if(stud.getStudy()!=null){
                table.addCell(stud.getStudy().getFaculty());
                table.addCell(nullCheck(stud.getStudy().getCourse_group()));
                table.addCell(nullCheck(stud.getStudy().getGraduate_year()));
            }else{
                fillEmpty(table,studyNumber);
            }

            if(stud.getWork()!=null){
                table.addCell(nullCheck(stud.getWork().getWorkStartDate()));
                table.addCell(nullCheck(stud.getWork().getHours_current().toString()));
                table.addCell(nullCheck(stud.getWork().isBillable().toString()));
                table.addCell(nullCheck(stud.getWork().getBillableStartDate().toString()));
                table.addCell(nullCheck(stud.getWork().getCurrentProjectRole().toString()));
            }else{
                fillEmpty(table,workNumber);
            }

            table.addCell("ДОПИСАТЬ");
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
        table.getDefaultCell().setWidth(70);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        table.getDefaultCell().setVerticalAlignment(Element.ALIGN_CENTER);
        addHeader(table);
        fillTable(table,listStud);
        document.add(table);
    }
}
