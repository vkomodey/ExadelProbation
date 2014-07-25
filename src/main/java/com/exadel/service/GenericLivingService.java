package com.exadel.service;

import com.exadel.model.IEntity;

public interface GenericLivingService<ENTITY extends IEntity> {
	ENTITY findById(long id);
}
