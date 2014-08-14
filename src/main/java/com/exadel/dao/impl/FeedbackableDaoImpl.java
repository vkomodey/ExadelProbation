package com.exadel.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.exadel.dao.FeedbackableDao;
import com.exadel.model.entity.Feedback;
import com.exadel.model.entity.government.Feedbackable;

@Repository
public class FeedbackableDaoImpl extends GenericLivingDaoImpl<Feedbackable>
		implements FeedbackableDao {

	@SuppressWarnings("unchecked")
	public List<Feedback> findForStudBy(String cur_name, long studId) {
		return getSessionFactory()
				.getCurrentSession()
				.createQuery(
						"from Feedback where author.name=:cur_name and student.id=:stud_id")
				.setString("cur_name", cur_name).setLong("stud_id", studId)
				.list();
	}

}
