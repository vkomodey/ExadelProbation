package com.exadel.controller.json;


import com.exadel.dao.StudentDao;
import com.exadel.dao.impl.StudentDaoImpl;
import com.exadel.model.entity.Feedback;
import com.exadel.model.entity.government.FeedbackAble;
import com.exadel.model.entity.government.Feedbacker;
import com.exadel.model.entity.government.Government;
import com.exadel.model.entity.student.*;
import com.exadel.model.entity.view.FeedbackView;
import com.exadel.service.StudentService;
import com.exadel.service.impl.StudentServiceImpl;
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

    public static Logger logger= LoggerFactory.getLogger(RegistrationController.class);

    @RequestMapping(value = RestURIConstants.PUSH_FEEDBACK_TO_BASE, method = RequestMethod.POST)
    public @ResponseBody
    void getJsonData(@RequestBody String str) {
        logger.info("Start saving feedback.");
        ObjectMapper mapper = new ObjectMapper();
        try {
            FeedbackView feedback = mapper.readValue(str,FeedbackView.class);
            StudentService studentService = new StudentServiceImpl();
            studentService.saveNewFeedbackForStudentByStudId(feedback,feedback.getStudId());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value=RestURIConstants.GET_FEEDBACK_ARRAY_FROM_BASE,method=RequestMethod.GET)
    public @ResponseBody
    List<FeedbackView> getDummyStudent(@PathVariable("id") String id){
        logger.info("Sending feedback list");
        long studId = Long.parseLong(id);
        List<FeedbackView> ar=new ArrayList<FeedbackView>();
        StudentService studentService = new StudentServiceImpl();
        ar=studentService.getFeedbacksForStudentByStudId(studId);
        System.out.println(studId);
        return ar;
    }

}
