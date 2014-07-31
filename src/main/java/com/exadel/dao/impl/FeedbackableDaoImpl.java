package com.exadel.dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.exadel.dao.FeedbackableDao;
import com.exadel.model.entity.government.Feedbackable;
@Repository
public class FeedbackableDaoImpl extends GenericLivingDaoImpl<Feedbackable> implements
        FeedbackableDao{

    public Feedbackable find(long id) {
        return (Feedbackable) getSessionFactory().getCurrentSession().load(Feedbackable.class,id);
    }


    public List<Feedbackable> getAll() {
        return null;
    }


    public Feedbackable find(String login) {
        return null;
    }
}

