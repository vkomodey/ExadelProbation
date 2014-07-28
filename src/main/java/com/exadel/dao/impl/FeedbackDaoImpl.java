package com.exadel.dao.impl;

import com.exadel.dao.FeedbackDao;
import com.exadel.model.entity.Feedback;
import com.exadel.model.entity.student.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class FeedbackDaoImpl extends GenericDaoImpl<Feedback> implements
		FeedbackDao {
	
	public Feedback find(long id) {
		return (Feedback) getSessionFactory().getCurrentSession().get(Feedback.class,id);
	}

	@SuppressWarnings("unchecked")
	public List<Feedback> findAllForStud(Student stud) {
		Session session=getSessionFactory().getCurrentSession();
		Query query=session.createQuery("from Feedback where student=:student")
				.setEntity("student", stud);
		List<Feedback> result= query.list();
		return result;
	}

	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
