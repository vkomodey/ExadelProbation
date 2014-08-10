package com.exadel.dao;

import java.util.Set;

import com.exadel.model.entity.student.SkillType;


public interface SkillTypeDao extends GenericDao<SkillType>{
	public Set<String> getSkillNames();
	public SkillType find(String name);
}
