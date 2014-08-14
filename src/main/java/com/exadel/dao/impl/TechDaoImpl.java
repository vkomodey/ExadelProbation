package com.exadel.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.exadel.dao.TechDao;
import com.exadel.model.entity.student.Technology;

@Repository
public class TechDaoImpl extends GenericDaoImpl<Technology> implements
		TechDao {

	@SuppressWarnings("unchecked")
	public Set<String> getNames() {
		return new HashSet<String>(getSessionFactory().getCurrentSession()
				.createQuery("select distinct t.name from Technology t").list());
	}

	public Technology find(String name) {
		return (Technology) getSessionFactory().getCurrentSession()
				.bySimpleNaturalId(Technology.class).load(name);
	}
	
	@SuppressWarnings("unchecked")
	public List<Technology> getAllCurrentUsedByStudents() {
		return getSessionFactory().getCurrentSession().createQuery("select distinct s.work.currentUsedTechnologies from Student s").list();
	}

    @SuppressWarnings("unchecked")
    public List<Technology> getAllCurrentUsedByProjects(long projectId) {
        return getSessionFactory().getCurrentSession().createQuery("select distinct p.usedTechnologies from Project p where p.id=:id ").setLong("id",projectId).list();
    }

    //Warning! SQL query
    @SuppressWarnings("unchecked")
    public List<String> getAllDistinctSkills(){
        //List<Skill> list = getSessionFactory().getCurrentSession().createQuery("select distinct ON (s.skillSet) s.skillSet from Student s").list();
        List<BigInteger> list = getSessionFactory().getCurrentSession().
                createSQLQuery("select distinct on(type_id) type_id from skill").list();
        List<String> titles = new ArrayList<String>();
        for(BigInteger id:list){
            long temp = id.longValue();
            String title = ((Technology)getSessionFactory().getCurrentSession().load(Technology.class, temp)).getName();
            titles.add(title);
        }
        return titles;
    }

}
