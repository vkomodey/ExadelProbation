package com.exadel.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

public interface EmailDao{
    public List<String> getAllEmailsById(List<Long> listId);
}
