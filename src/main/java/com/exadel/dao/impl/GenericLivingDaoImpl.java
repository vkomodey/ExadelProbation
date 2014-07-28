package com.exadel.dao.impl;

import com.exadel.dao.GenericLivingDao;
import com.exadel.model.IEntity;
import org.springframework.stereotype.Repository;
@Repository
public abstract class GenericLivingDaoImpl <ENTITY extends IEntity>
        extends GenericDaoImpl<ENTITY> implements GenericLivingDao<ENTITY> {

}
