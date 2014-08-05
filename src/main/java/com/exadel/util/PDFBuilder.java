package com.exadel.util;


import com.exadel.model.entity.student.Student;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class PDFBuilder extends AbstractPdfView {

    static final int tableSize=13;

    private void addHeader(Table table) throws BadElementException {
        table.addCell("Id");
        table.addCell("First Name");
        table.addCell("Second Name");
        table.addCell("Surname");
        table.addCell("Work start date");
        table.addCell("Faculty");
        table.addCell("Course/Group");
        table.addCell("Graduate year");
        table.addCell("Current working hours");
        table.addCell("Billable/Not billable");
        table.addCell("Billable start date");
        table.addCell("Project role");
        table.addCell("Current project technology");
        table.addCell("English level");
    }

    private void fillTable(Table table,List<Student> listStud) throws BadElementException {
        for (Student stud : listStud) {
            table.addCell(stud.getId().toString());
            table.addCell(stud.getFirstName());
            table.addCell(stud.getSecondName());
            table.addCell(stud.getSurname());
            table.addCell(stud.getWork().getWorkStartDate().toString());
            table.addCell(stud.getStudy().getFaculty());
            table.addCell(stud.getStudy().getCourse_group());
            table.addCell(stud.getStudy().getGraduate_year().toString());
            table.addCell(stud.getWork().getHours_current().toString());
            table.addCell(stud.getWork().isBillable().toString());
            table.addCell(stud.getWork().getBillableStartDate().toString());
            table.addCell(stud.getWork().getCurrentProjectRole().toString());
            table.addCell("ДОПИСАТЬ!!!!!!!!!!!");
            table.addCell(stud.getEnglish().toString());
        }
    }

    @Override
    protected void buildPdfDocument(Map model, Document document,
                                    PdfWriter writer, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {

        List<Student> listStud = (List<Student>) model.get("list");
        Table table = new Table(tableSize);
        addHeader(table);
        fillTable(table,listStud);
        document.add(table);
    }
}
