package com.exadel.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.exadel.model.entity.Feedback;
import com.exadel.model.entity.government.Curator;
import com.exadel.model.entity.government.Feedbacker;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.exadel.dao.UserDao;
import com.exadel.model.entity.User;

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

	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

    public List<User> getAllEmployees(){
        List<User> employees = new ArrayList<User>();
        List<Curator> curators = getSessionFactory().getCurrentSession().createQuery("from Curator ").list();
//        for(Curator curator:curators){
//            for(Feedback feedback: curator.getFeedback()){
//                feedback.getBillableNow();
//            }
//            curator.getRole();
//        }
        List<Feedbacker> feedbackers = getSessionFactory().getCurrentSession().createQuery("from Feedbacker").list();
//        for(Feedbacker feedbacker:feedbackers){
//            feedbacker.getRole();
//        }
        employees.addAll(curators);
        employees.addAll(employees.size(), feedbackers);
        return employees;
    }

}
