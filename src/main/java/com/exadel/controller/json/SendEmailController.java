package com.exadel.controller.json;

import com.exadel.controller.json.constants.EmailURI;
import com.exadel.service.StudentService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Controller
public class SendEmailController {
    private static Logger logger= LoggerFactory.getLogger(SendEmailController.class);
    @Autowired
    StudentService studentService;
    @Autowired
    private MailSender mailSender;
    @RequestMapping(value = EmailURI.SEND_EMAIL, method = RequestMethod.POST)
    public @ResponseBody void sendEmail(@RequestBody String str,ObjectMapper om) throws IOException {
    	TypeReference<List<Long>> listOfLongType=new TypeReference<List<Long>>() {};
    	JsonNode rootnode=om.readTree(str);
    	List<Long> ids=om.readValue(rootnode.path("id").traverse(), listOfLongType);
    	String messageText=rootnode.get("message").asText();
        List<String> allEmailsById = studentService.getAllEmailAddressesOfStudents(ids);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setText(messageText);
        message.setSubject(messageText);
        for(String email: allEmailsById){
            logger.info("start sending message to " + email);
            message.setTo(email);
            mailSender.send(message);
            logger.info("finish sending message to " + email);
        }
    }
}
