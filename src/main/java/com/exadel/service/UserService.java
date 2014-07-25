package com.exadel.service;

import com.exadel.model.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService extends UserDetailsService {
    User findUserById(int userId);

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}