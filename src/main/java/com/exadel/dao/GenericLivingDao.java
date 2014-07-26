package com.exadel.dao;

import com.exadel.model.IEntity;

public interface GenericLivingDao <ENTITY extends IEntity> {
    public abstract ENTITY find(long id);
    public abstract void save(ENTITY entity); 
}
