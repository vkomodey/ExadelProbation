package com.exadel.dao;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.exadel.model.entity.User;

import java.util.List;

public interface UserDao extends GenericLivingDao<User> {
    UserDetails loadUserByUsername(String login) throws UsernameNotFoundException;

    List<User> getAllEmployees();
}
