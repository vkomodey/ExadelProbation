package com.exadel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exadel.dao.CuratorDao;
import com.exadel.model.entity.government.Curator;
import com.exadel.model.entity.student.Student;
import com.exadel.service.CuratorService;

@Service
public class CuratorServiceImpl extends GenericLivingServiceImpl<Curator> implements CuratorService {
    @Autowired
    CuratorDao curatorDao;

    @Transactional
    public Curator find(String login) {
        return curatorDao.find(login);
    }
    private void lazyTouch(Student student){
        student.getStudy().getExams().size();
        student.getSkillSet().size();
    }

    @Transactional
    public List<Student> getSupervised(long curatorId){
        List<Student>list = curatorDao.getSupervised(curatorId);
        for(Student s:list){
            lazyTouch(s);
        }
        return curatorDao.getSupervised(curatorId);
    }
}
