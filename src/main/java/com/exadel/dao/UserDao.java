package com.exadel.dao;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.exadel.model.entity.User;

public interface UserDao extends GenericLivingDao<User> {
    UserDetails loadUserByUsername(String login) throws UsernameNotFoundException;

    List<User> getAllEmployees();
}
