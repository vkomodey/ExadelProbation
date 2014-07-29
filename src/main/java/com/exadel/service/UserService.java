package com.exadel.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.exadel.model.entity.User;

public interface UserService extends UserDetailsService,GenericLivingService<User> {

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

	String roleFor(String name);

	User findByLogin(String name);
}
