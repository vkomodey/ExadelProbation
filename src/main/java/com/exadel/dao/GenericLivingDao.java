package com.exadel.dao;

import com.exadel.model.IEntity;

public interface GenericLivingDao <ENTITY extends IEntity> extends GenericNamedDao<ENTITY> {
    public ENTITY find(String login);
}
