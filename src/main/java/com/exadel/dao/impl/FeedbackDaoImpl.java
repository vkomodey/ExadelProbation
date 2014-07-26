package com.exadel.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.exadel.dao.FeedbackDao;
import com.exadel.model.entity.Feedback;
import com.exadel.model.entity.student.Student;

public class FeedbackDaoImpl extends GenericDaoImpl<Feedback> implements
		FeedbackDao {
	
	@SuppressWarnings("unchecked")
	public List<Feedback> findAllForStud(Student stud) {
		Session session=getSessionFactory().getCurrentSession();
		Query query=session.createQuery("select from Feedback where student=:student")
				.setEntity("student", stud);
		List<Feedback> result= query.list();
		return result;
	}

	public Feedback find(long id) {
		return (Feedback) getSessionFactory().getCurrentSession().get(Feedback.class,id);
	}

}
