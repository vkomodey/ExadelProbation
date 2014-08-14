package com.exadel.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.exadel.dao.TechDao;
import com.exadel.model.entity.student.Technology;

@Repository
public class TechDaoImpl extends GenericNamedDaoImpl<Technology> implements
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
}
