package com.exadel.dao;

import com.exadel.model.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDao extends GenericLivingDao<User> {
    UserDetails loadUserByUsername(String login) throws UsernameNotFoundException;

	
}
