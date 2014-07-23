package com.exadel.dao;

import com.exadel.model.IEntity;

import java.io.Serializable;

public interface GenericDao <ENTITY extends IEntity, ID extends Serializable> {
    ENTITY find(ID id);
}
