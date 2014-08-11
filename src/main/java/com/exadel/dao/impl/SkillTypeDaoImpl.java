package com.exadel.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.exadel.dao.SkillTypeDao;
import com.exadel.model.entity.student.SkillType;

@Repository
public class SkillTypeDaoImpl extends GenericDaoImpl<SkillType> implements
		SkillTypeDao {

	@SuppressWarnings("unchecked")
	public Set<String> getSkillNames() {
		return new HashSet<String>(getSessionFactory().getCurrentSession()
				.createQuery("select t.name from SkillType t").list());
	}

	public SkillType find(String name) {
		return (SkillType) getSessionFactory().getCurrentSession()
				.bySimpleNaturalId(SkillType.class).load(name);
	}

}
