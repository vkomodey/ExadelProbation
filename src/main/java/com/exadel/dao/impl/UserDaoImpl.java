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
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        System.out.println("CHECK CHECK dao");
        org.hibernate.Session s = getSessionFactory().openSession();
        final User user = (User)s.
                createQuery("from User where login=:login").
                setString("login", login).
                uniqueResult();
    System.out.println("AZAZA - " + user.getLogin());
        Object details = new UserDetails() {
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return new ArrayList<SimpleGrantedAuthority>(1){{
                    add(new SimpleGrantedAuthority(user.getRole()));
                }};
            }

            public String getPassword() {
                return user.getPassword();
            }

            public String getUsername() {
                return user.getLogin();
            }

            public boolean isAccountNonExpired() {
                return true;
            }

            public boolean isAccountNonLocked() {
                return true;
            }

            public boolean isCredentialsNonExpired() {
                return true;
            }

            public boolean isEnabled() {
                return true;
            }
        };
        System.out.println("ROLE - " + ((UserDetails)details).getAuthorities() +" NAME - " + ((UserDetails)details).getUsername());
        return (UserDetails)details;
    }

    public User find(Integer integer) {
        return null;
    }
}
