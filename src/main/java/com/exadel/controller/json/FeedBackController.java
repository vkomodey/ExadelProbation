package com.exadel.controller.json;


import com.exadel.model.entity.view.FeedbackView;
import com.exadel.service.StudentService;
import com.exadel.service.impl.StudentServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FeedBackController {

    public static Logger logger= LoggerFactory.getLogger(RegistrationController.class);
    @Autowired
    StudentService service;

    @RequestMapping(value = RestURIConstants.PUSH_FEEDBACK_TO_BASE, method = RequestMethod.POST)
    public @ResponseBody
    void saveFeedback(@RequestBody String str) {
        logger.info("Start saving feedback.");
        ObjectMapper mapper = new ObjectMapper();
        try {
            FeedbackView feedback = mapper.readValue(str, FeedbackView.class);
            service.saveNewFeedbackForStudentByStudId(feedback,feedback.getStudId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value=RestURIConstants.GET_FEEDBACK_ARRAY_FROM_BASE,method=RequestMethod.GET)
    public @ResponseBody
    List<FeedbackView> returnFeedbackList(@PathVariable("id") String id){
        logger.info("Sending feedback list");
        try {
            long studId = Long.parseLong(id);
            return service.getFeedbacksForStudentByStudId(studId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
