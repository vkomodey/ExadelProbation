package com.exadel.model.entity.government;

import javax.persistence.Entity;
import javax.persistence.Transient;

import com.exadel.model.constants.SpringSecurityRole;

@Entity
public class Feedbacker extends FeedbackAble {

	public Feedbacker() {
		super();
	}
	@Override
	@Transient
	public String getRole(){
		return SpringSecurityRole.FEEDBACKER;
	}

}
