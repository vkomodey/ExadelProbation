package com.exadel.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.exadel.model.constants.SpringSecurityRole;
import com.exadel.model.entity.government.Curator;
import com.exadel.model.entity.government.Feedbacker;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.exadel.dao.UserDao;
import com.exadel.model.entity.User;
import com.exadel.model.view.EmployeeView;

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
    public com.exadel.model.entity.User find(String login) {

        return (com.exadel.model.entity.User) getSessionFactory().getCurrentSession().bySimpleNaturalId(com.exadel.model.entity.User.class).load(login);
    }

	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

    public List<EmployeeView> getAllEmployees(){
        List<EmployeeView> employees = new ArrayList<EmployeeView>();
        List<Curator> curators = getSessionFactory().getCurrentSession().createQuery("from Curator ").list();
        List<Feedbacker> feedbackers = getSessionFactory().getCurrentSession().createQuery("from Feedbacker").list();
        for(int i = 0; i < curators.size();++i){
            EmployeeView temp = new EmployeeView();
            temp.setId(curators.get(i).getId());
            temp.setFIO(curators.get(i).getFullName());
            temp.setEmail("cur_em"+i+"@mail.org");
            temp.setRole(SpringSecurityRole.CURATOR);
            employees.add(temp);
        }

        for(int i = 0; i < feedbackers.size(); ++i){
            EmployeeView temp = new EmployeeView();
            temp.setId(feedbackers.get(i).getId());
            temp.setFIO(feedbackers.get(i).getFullName());
            temp.setEmail("feed_em"+i+"@mail.org");
            temp.setRole(SpringSecurityRole.FEEDBACKER);
            employees.add(temp);
        }
        return employees;
    }

}
