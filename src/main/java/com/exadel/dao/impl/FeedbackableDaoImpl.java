package com.exadel.dao.impl;


import com.exadel.dao.FeedbackableDao;
import com.exadel.model.entity.government.FeedbackAble;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class FeedbackableDaoImpl extends GenericLivingDaoImpl<FeedbackAble> implements
        FeedbackableDao{

    public FeedbackAble find(long id) {
        return (FeedbackAble) getSessionFactory().getCurrentSession().load(FeedbackAble.class,id);
    }


    public List<FeedbackAble> getAll() {
        return null;
    }


    public FeedbackAble find(String login) {
        return null;
    }
}

