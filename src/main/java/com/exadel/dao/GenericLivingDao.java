package com.exadel.dao;

import com.exadel.model.IEntity;

import java.util.List;

public interface GenericLivingDao <ENTITY extends IEntity> extends GenericDao<ENTITY> {
    public abstract ENTITY find(String login);

}
