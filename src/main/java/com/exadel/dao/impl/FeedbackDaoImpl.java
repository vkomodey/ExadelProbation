package com.exadel.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.exadel.dao.FeedbackDao;
import com.exadel.model.entity.Feedback;
import com.exadel.model.entity.student.Student;
@Repository
public class FeedbackDaoImpl extends GenericDaoImpl<Feedback> implements
		FeedbackDao {
	@SuppressWarnings("unchecked")
	public List<Feedback> findAllForStud(Student stud) {
		Session session=getSessionFactory().getCurrentSession();
		Query query=session.createQuery("from Feedback where student=:student")
				.setEntity("student", stud);
		List<Feedback> result= query.list();
		return result;
	}
}
