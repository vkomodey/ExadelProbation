/*
package com.exadel.controller.tests;


import com.exadel.dao.StudentDAO;
import com.exadel.dao.impl.StudentDAOImpl;
import com.exadel.model.entity.student.Student;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test2 {
    public static void main(String args[]) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "persistance.xml" }, true);

        Student s1 = new Student();
        StudentDAO studentDAO = new StudentDAOImpl();

        //Проинициализируем их
        s1.setFirstName("Ivanov");
        s1.setSecondName("Ivan");
        s1.setSurname("ieurnb");
        s1.setLogin("sdfghjk");
        s1.setPassword("123456789");

        studentDAO.save(s1);
    }
}
*/
