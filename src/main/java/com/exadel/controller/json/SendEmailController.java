package com.exadel.controller.json;

import com.exadel.model.entity.view.EmailView;
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

@Controller
public class SendEmailController {
    private static Logger logger= LoggerFactory.getLogger(SendEmailController.class);
    @Autowired
    private MailSender mailSender;
    @RequestMapping(value = "send/email", method = RequestMethod.POST)
    public void sendEmail(@RequestBody String str) throws IOException {
        logger.info("start sending email");
        SimpleMailMessage message = new SimpleMailMessage();
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(str);
        EmailView id = mapper.readValue(str, EmailView.class);
        System.out.println(id.getId());
        System.out.println(id.getMessage());

        message.setTo("garethspurs95@gmail.com");
        message.setSubject("Test subject");
        message.setText("Test message");
        mailSender.send(message);
        logger.info("finish sending email");
    }
}
