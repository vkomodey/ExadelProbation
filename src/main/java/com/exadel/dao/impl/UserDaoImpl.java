package com.exadel.dao.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.Session;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.exadel.dao.UserDao;
import com.exadel.model.entity.User;

@Repository
public class UserDaoImpl extends GenericLivingDaoImpl<User> implements UserDao {
	public User find(long id) {
		return (User) getSessionFactory().getCurrentSession().load(User.class,
				id);
	}

	public User find(String login) {
		Session session = getSessionFactory().getCurrentSession();
		User user = (User) session.bySimpleNaturalId(User.class).load("login");
		return user;
	}

	public UserDetails loadUserByUsername(String login)
			throws UsernameNotFoundException {
		/*
		 * System.out.println("CHECK CHECK dao"); org.hibernate.Session s =
		 * getSessionFactory().getCurrentSession(); final User user = (User)s.
		 * createQuery("from User where login=:login"). setString("login",
		 * login). uniqueResult();
		 */
		final User user = this.find(login);
		// System.out.println("AZAZA - " + user.getLogin());

		Object details = new UserDetails() {
			public Collection<? extends GrantedAuthority> getAuthorities() {
				return new ArrayList<SimpleGrantedAuthority>(1) {
					{
						add(new SimpleGrantedAuthority(user.getRole()));
					}
				};
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
		// System.out.println("ROLE - " +
		// ((UserDetails)details).getAuthorities() +" NAME - " +
		// ((UserDetails)details).getUsername());
		return (UserDetails) details;
	}
}
