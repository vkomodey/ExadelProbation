package com.exadel.service.impl;

import com.exadel.model.entity.student.ExadelWork;
import com.exadel.model.entity.student.ExadelPractice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exadel.dao.StudentDao;
import com.exadel.dao.UserDao;
import com.exadel.model.constants.SpringSecurityRole;
import com.exadel.model.entity.User;
import com.exadel.model.entity.government.Curator;
import com.exadel.model.entity.government.Feedbacker;
import com.exadel.model.entity.government.Joanna;
import com.exadel.model.entity.government.PersonnelDepartment;
import com.exadel.model.entity.student.Student;
import com.exadel.model.view.RegistrationView;
import com.exadel.service.RegistrationService;

import java.util.Calendar;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    public static final String DEFAULT_PASSWORD = "11111";
    @Autowired
    UserDao userDao;
    @Autowired
    StudentDao studentDao;

    @Secured({SpringSecurityRole.ADMIN})
    public User initUser(RegistrationView view){
        User user;
        switch (view.getRole()) {
            case SpringSecurityRole.FEEDBACKER:
                user = new Feedbacker();
                break;
            case SpringSecurityRole.ADMIN:
                user = new Joanna();
                break;
            case SpringSecurityRole.CURATOR:
                user = new Curator();
                break;
            case SpringSecurityRole.PERSONNEL_DEPARTMENT:
                user = new PersonnelDepartment();
                break;
            default:
                user = new User();
                break;
        }
        user.setLogin(view.getLogin());
        user.setPassword(DEFAULT_PASSWORD);
        return user;
    }

	@Transactional
    @Secured({SpringSecurityRole.ADMIN})
    public void registerAnyone(RegistrationView view) {
        User user=initUser(view);
        switch (view.getRole()) {
            case SpringSecurityRole.FEEDBACKER:

                break;
            case SpringSecurityRole.ADMIN:

                break;
            case SpringSecurityRole.CURATOR:

                break;
            case SpringSecurityRole.PERSONNEL_DEPARTMENT:

                break;
            default:
                userDao.save(user);
                break;
        }
	}
    @Transactional
    @Secured({SpringSecurityRole.ADMIN})
	public void registerStudent(RegistrationView view) {
		view.setRole(SpringSecurityRole.STUDENT);
        Student stud=new Student();
        stud.setLogin(view.getLogin());
        stud.setPassword(DEFAULT_PASSWORD);
        ExadelPractice studPractice = new ExadelPractice();
        studPractice.setOnProbation(true);
        studPractice.setPracticeStart(Calendar.getInstance());
        stud.setPractice(studPractice);
        studentDao.save(stud);
	}
}
