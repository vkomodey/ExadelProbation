package com.exadel.model.entity.government;

import javax.persistence.Entity;
import javax.persistence.Transient;

import com.exadel.model.constants.SpringSecurityRole;
import com.exadel.model.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class PersonnelDepartment extends User implements Government{
	@Override
	@Transient
	@JsonIgnore
	public String getRole(){
		return SpringSecurityRole.PERSONNEL_DEPARTMENT;
	}
}
