package com.exadel.dao.impl;

import com.exadel.dao.UserDao;
import com.exadel.model.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User, Integer> implements UserDao {
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        System.out.println("CHECK CHECK dao");
        org.hibernate.Session s = getSessionFactory().openSession();
        final User user = (User)s.
                createQuery("from User where login=:login").
                setString("login", login).
                uniqueResult();
        Object details = new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return new ArrayList(1){{
                    add(new SimpleGrantedAuthority(user.getRole()));
                }};
            }

            @Override
            public String getPassword() {
                return user.getPassword();
            }

            @Override
            public String getUsername() {
                return user.getLogin();
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }
        };
        System.out.println("ROLE - " + ((UserDetails)details).getAuthorities() +" NAME - " + ((UserDetails)details).getUsername());
        return (UserDetails)details;
    }

    @Override
    public User find(Integer integer) {
        return null;
    }
}
