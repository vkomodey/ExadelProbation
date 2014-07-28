package com.exadel.model.entity.government;

import com.exadel.model.constants.SpringSecurityRole;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class Curator extends FeedbackAble {
	@Override
	@Transient
	@JsonIgnore
	public String getRole(){
		return SpringSecurityRole.CURATOR;
	}
}
