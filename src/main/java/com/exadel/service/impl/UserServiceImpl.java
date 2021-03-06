package com.exadel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exadel.dao.UserDao;
import com.exadel.model.entity.User;
import com.exadel.model.view.EmployeeView;
import com.exadel.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl extends GenericLivingServiceImpl<User> implements
		UserService {
	@Autowired
	UserDao userDao;

	@Transactional
	public UserDetails loadUserByUsername(String login)
			throws UsernameNotFoundException {
		return userDao.loadUserByUsername(login);
	}

	@Override
	public User findById(long id) {
		return userDao.find(id);
	}

	@Transactional
	public User findByLogin(String name) {
		return userDao.find(name);
	}

	@Transactional
	public List<EmployeeView> getAllEmployees() {
		return userDao.getAllEmployees();
	}

	@Transactional
	public void save(User user) {
		userDao.save(user);
	}

}
