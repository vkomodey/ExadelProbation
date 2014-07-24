package com.exadel.model.entity.government;

import javax.persistence.Transient;

import com.exadel.model.constants.SpringSecurityRole;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class PersonnelDepartment extends Government {
	@Override
	@Transient
	@JsonIgnore
	public String getRole(){
		return SpringSecurityRole.PERSONNEL_DEPARTMENT;
	}
}
