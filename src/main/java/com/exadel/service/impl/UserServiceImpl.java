package com.exadel.service.impl;

import com.exadel.model.entity.view.EmployeeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exadel.dao.UserDao;
import com.exadel.model.entity.User;
import com.exadel.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl extends GenericLivingServiceImpl<User> implements UserService {
	@Autowired
	UserDao mainDao;
	@Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return mainDao.loadUserByUsername(login);
    }

    @Override
    public User findById(long id) {
        return null;
    }

    @Transactional
    public User findByLogin(String name){
        return mainDao.find(name);
    }

    @Transactional
    public List<EmployeeView> getAllEmployees(){
        return mainDao.getAllEmployees();
    }

    @Transactional
    public void save(User user){

    }


}
