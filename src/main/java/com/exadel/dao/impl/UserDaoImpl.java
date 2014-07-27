package com.exadel.dao.impl;

import com.exadel.dao.UserDao;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class UserDaoImpl extends GenericLivingDaoImpl<com.exadel.model.entity.User> implements UserDao {
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        System.out.println("CHECK CHECK dao");
        final com.exadel.model.entity.User user = this.find(login);
        return new org.springframework.security.core.userdetails.User(user.getLogin(),
                user.getPassword(),
                new ArrayList<SimpleGrantedAuthority>(1){{
            add(new SimpleGrantedAuthority(user.getRole()));
        }});
    }

    public com.exadel.model.entity.User find(long id) {
        return (com.exadel.model.entity.User) getSessionFactory().getCurrentSession().load(com.exadel.model.entity.User.class, id);
    }

    public com.exadel.model.entity.User find(String login) {
        return (com.exadel.model.entity.User) getSessionFactory().getCurrentSession().bySimpleNaturalId(com.exadel.model.entity.User.class).load(login);
    }

}
