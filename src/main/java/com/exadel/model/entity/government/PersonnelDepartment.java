package com.exadel.model.entity.government;

import javax.persistence.Transient;

import com.exadel.model.constants.SpringSecurityRole;

public class PersonnelDepartment extends Government {
	@Override
	@Transient
	public String getRole(){
		return SpringSecurityRole.PERSONNEL_DEPARTMENT;
	}
}
