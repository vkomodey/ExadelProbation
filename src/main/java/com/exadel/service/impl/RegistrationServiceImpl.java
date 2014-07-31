package com.exadel.service.impl;

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
import com.exadel.model.entity.view.RegistrationView;
import com.exadel.service.RegistrationService;
@Service
public class RegistrationServiceImpl implements RegistrationService {
	@Autowired
    UserDao userDao;
    @Autowired
    StudentDao studentDao;

    @Secured({"ROLE_ADMIN"})
    public User initUser(RegistrationView view){
        User user;
        switch (view.getRole()) {
            case SpringSecurityRole.STUDENT:
                user = new Student();
                break;
            case SpringSecurityRole.FEEDBACKER:
                user = new Feedbacker();
                break;
            case SpringSecurityRole.JOANNA:
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
        user.setPassword("11111");
        return user;
    }

	@Transactional
    @Secured({"ROLE_ADMIN"})
    public void registerAnyone(RegistrationView view) {
        User user=initUser(view);
        switch (view.getRole()) {
            case SpringSecurityRole.STUDENT:
                studentDao.save((Student)user);
                break;
            case SpringSecurityRole.FEEDBACKER:

                break;
            case SpringSecurityRole.JOANNA:

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
	public void registerStudent(RegistrationView view) {
		view.setRole(SpringSecurityRole.STUDENT);
		this.registerAnyone(view);
	}
}
