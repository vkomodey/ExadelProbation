package com.exadel.model.entity.government;

import com.exadel.model.constants.SpringSecurityRole;
import com.exadel.model.entity.User;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
public abstract class Government extends User {
	@Override
	@Transient
	public String getRole(){
		return SpringSecurityRole.GOVERNMENT;
	}
}
