package com.exadel.dao.impl;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.exadel.dao.TechnologyDao;
import com.exadel.model.entity.student.Technology;

@Repository
public class TechnologyDaoImpl extends GenericDaoImpl<Technology> implements
		TechnologyDao {

	@SuppressWarnings("unchecked")
	public List<Technology> getAll() {
		return getSessionFactory().getCurrentSession()
				.createQuery("from Technology").list();
	}

	public Technology find(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Technology> getAllCurrentUsedByStudents() {
		return getSessionFactory().getCurrentSession().createQuery("select distinct s.work.currentUsedTechnologies from Student s").list();
	}

}
