package com.exadel.dao;


import java.util.List;

import com.exadel.model.entity.Feedback;
import com.exadel.model.entity.government.Feedbackable;

public interface FeedbackableDao extends GenericLivingDao<Feedbackable>{

	List<Feedback> findForStudBy(String cur_name, long studId);
}
