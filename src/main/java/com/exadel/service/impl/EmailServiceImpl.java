package com.exadel.service.impl;

import com.exadel.dao.EmailDao;
import com.exadel.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    EmailDao emailDao;
    @Transactional
    public List<String> getAllEmailsById(List<Long> listId){
        return emailDao.getAllEmailsById(listId);
    }
}
