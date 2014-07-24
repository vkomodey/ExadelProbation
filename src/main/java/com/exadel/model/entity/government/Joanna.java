package com.exadel.model.entity.government;

import javax.persistence.Entity;
import javax.persistence.Transient;

import com.exadel.model.constants.SpringSecurityRole;

@Entity
public class Joanna extends FeedbackAble {
	@Override
	@Transient
	public String getRole(){
		return SpringSecurityRole.JOANNA;
	}
}
