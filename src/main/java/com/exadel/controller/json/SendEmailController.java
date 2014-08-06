package com.exadel.controller.json;

import com.exadel.model.entity.view.EmailView;
import com.exadel.service.EmailService;
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

import java.io.IOException;
import java.util.List;

@Controller
public class SendEmailController {
    private static Logger logger= LoggerFactory.getLogger(SendEmailController.class);
    @Autowired
    EmailService emailService;
    @Autowired
    private MailSender mailSender;
    @RequestMapping(value = "send/email", method = RequestMethod.POST)
    public void sendEmail(@RequestBody String str) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        EmailView emailView = mapper.readValue(str, EmailView.class);
        List<String> allEmailsById = emailService.getAllEmailsById(emailView.getId());
        SimpleMailMessage message = new SimpleMailMessage();
        message.setText(emailView.getMessage());
        for(String email: allEmailsById){
            logger.info("start sending message to " + email);
            message.setTo(email);
            mailSender.send(message);
            logger.info("finish sending message to " + email);
        }
    }
}