package com.exadel.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.exadel.model.entity.User;
import com.exadel.model.view.EmployeeView;

import java.util.List;

public interface UserService extends UserDetailsService,GenericLivingService<User> {

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

	User findByLogin(String name);

    List<EmployeeView> getAllEmployees();
}
