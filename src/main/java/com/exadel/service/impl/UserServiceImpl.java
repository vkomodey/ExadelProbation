package com.exadel.service.impl;

import com.exadel.dao.impl.UserDaoImpl;
import com.exadel.model.entity.User;
import com.exadel.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl extends GenericLivingServiceImpl<User> implements UserService {
	@Autowired
	UserDaoImpl dao;
	@Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return dao.loadUserByUsername(login);
    }
}
