package com.exadel.model.entity.government;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import com.exadel.model.constants.SpringSecurityRole;
import com.exadel.model.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

@MappedSuperclass
public abstract class Government extends User{
	@Transient
	@JsonIgnore
	public String getRole(){
		return SpringSecurityRole.GOVERNMENT;
	}
}
