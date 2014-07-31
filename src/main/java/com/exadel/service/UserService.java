package com.exadel.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.exadel.model.entity.User;

public interface UserService extends UserDetailsService,GenericLivingService<User> {

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

	User findByLogin(String name);

    List<User> getAllEmployees();
}
