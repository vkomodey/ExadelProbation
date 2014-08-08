package com.exadel.dao;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.exadel.model.entity.User;
import com.exadel.model.view.EmployeeView;

import java.util.List;

public interface UserDao extends GenericLivingDao<User> {
    UserDetails loadUserByUsername(String login) throws UsernameNotFoundException;

    List<EmployeeView> getAllEmployees();
}
