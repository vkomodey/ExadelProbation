package com.exadel.controller.json;

import java.util.ArrayList;
import java.util.List;

import com.exadel.model.entity.student.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileExportController {

    @RequestMapping(value = "/downloadExcel", method = RequestMethod.GET)
    public ModelAndView downloadExcel() {

        // create some sample data
        List<Student> listBooks = new ArrayList<Student>();
       /* listBooks.add(new Student("Effective Java", "Joshua Bloch", "0321356683",
                "May 28, 2008", 38.11F));
        listBooks.add(new Student("Head First Java", "Kathy Sierra & Bert Bates",
                "0596009208", "February 9, 2005", 30.80F));
        listBooks.add(new Student("Java Generics and Collections",
                "Philip Wadler", "0596527756", "Oct 24, 2006", 29.52F));
        listBooks.add(new Student("Thinking in Java", "Bruce Eckel", "0596527756",
                "February 20, 2006", 43.97F));
        listBooks.add(new Student("Spring in Action", "Craig Walls", "1935182358",
                "June 29, 2011", 31.98F));*/

        // return a view which will be resolved by an excel view resolver
        return new ModelAndView("excelView", "listBooks", listBooks);

    }
}
