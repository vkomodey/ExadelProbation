package com.exadel.controller.json;


import com.exadel.model.entity.Feedback;
import com.exadel.model.entity.government.FeedbackAble;
import com.exadel.model.entity.government.Feedbacker;
import com.exadel.model.entity.government.Government;
import com.exadel.model.entity.student.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FeedBackController {

    private Student buildDummy(){
        logger.info("dummy student build");
        Feedback fb = new Feedback();

        FeedbackAble chuvak=new Feedbacker();

        fb.setWorkAttitude("ZAAAAADR");
        fb.setProfCompetence(true);
        fb.setCollectiveRelations("sexoholic");
        fb.setProfMattersProgress("superMan");
        fb.setNeedMoreHours(true);
        fb.getStudent().getWork().setBillable(true);
        fb.setAuthor(chuvak);
        ArrayList<Feedback> arr = new ArrayList<Feedback>();

        Student stud=new Student();
        stud.setFeedback(arr);
        return stud;
    }

    public static Logger logger= LoggerFactory.getLogger(RegistrationController.class);

    @RequestMapping(value = RestURIConstants.PUSH_FEEDBACK_TO_BASE, method = RequestMethod.POST)
    public @ResponseBody
    void getJsonData(@RequestBody String str) {
        logger.info("Start createStudent.");
        ObjectMapper mapper = new ObjectMapper();
        try {
            Student student =  mapper.readValue(str,Student.class);
            logger.info("login:"+student.getLogin());

            // дальше типа сохраняем

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value=RestURIConstants.GET_FEEDBACK_ARRAY_FROM_BASE,method=RequestMethod.GET)
    public @ResponseBody
    //List<Feedback> getDummyStudent(@PathVariable("id") String id){
    ArrayList<Student> getDummyStudent(@PathVariable("id") String id){
        logger.info("dummy student sending");

        long studId = Long.parseLong(id);

       /* StudentDao studentDao = new StudentDaoImpl();
        Student st= studentDao.findStudentById(studId);

        return st.getFeedback();*/
        System.out.println(studId);

        ArrayList<Student> ar=new ArrayList<Student>();
        for(int i=0;i<5;i++)
            ar.add(buildDummy());
        return ar;

    }

}
