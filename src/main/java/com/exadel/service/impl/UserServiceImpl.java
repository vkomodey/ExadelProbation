package com.exadel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exadel.dao.UserDao;
import com.exadel.model.entity.User;
import com.exadel.service.UserService;

@Service
public class UserServiceImpl extends GenericLivingServiceImpl<User> implements UserService {
	@Autowired
	UserDao mainDao;
	@Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return mainDao.loadUserByUsername(login);
    }

    @Transactional
    public User findByLogin(String name){
        return mainDao.find(name);
    }

    @Transactional
    public List<User> getAllEmployees(){
        return mainDao.getAllEmployees();
    }

    @Transactional
	public User findById(long id) {
		return mainDao.find(id);
	}

    @Transactional
	public void save(User entity) {
		mainDao.save(entity);
	}
}
