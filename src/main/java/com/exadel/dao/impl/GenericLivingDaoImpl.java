package com.exadel.dao.impl;

import org.springframework.stereotype.Repository;

import com.exadel.dao.GenericLivingDao;
import com.exadel.model.IEntity;
@Repository
public abstract class GenericLivingDaoImpl <ENTITY extends IEntity>
        extends GenericNamedDaoImpl<ENTITY> implements GenericLivingDao<ENTITY> {
}
