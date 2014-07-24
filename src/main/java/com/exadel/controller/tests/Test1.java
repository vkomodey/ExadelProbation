/*
package com.exadel.controller.tests;


import com.exadel.dao.StudentDAO;
import com.exadel.dao.impl.StudentDAOImpl;
import com.exadel.model.entity.student.Student;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;


@Controller
@RequestMapping("/")
public class Test1 {

    @RequestMapping(value = "/test", method = RequestMethod.GET)

    public String testMethod() throws SQLException {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "/WEB-INF/web.xml" }, true);

        Student s1 = new Student();
        StudentDAO studentDAO = new StudentDAOImpl();

        //Проинициализируем их
        s1.setFirstName("Ivanov");
        s1.setSecondName("Ivan");
        s1.setSurname("ieurnb");
        s1.setLogin("sdfghjk");
        s1.setPassword("123456789");

        studentDAO.save(s1);

        return "<h1>Hallo!!!</h1>";
    }

}
*/
