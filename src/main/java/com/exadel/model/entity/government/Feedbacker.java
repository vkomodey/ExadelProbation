package com.exadel.model.entity.government;

import com.exadel.model.constants.SpringSecurityRole;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class Feedbacker extends FeedbackAble {

	public Feedbacker() {
		super();
	}
	@Override
	@Transient
	@JsonIgnore
	public String getRole(){
		return SpringSecurityRole.FEEDBACKER;
	}

}
