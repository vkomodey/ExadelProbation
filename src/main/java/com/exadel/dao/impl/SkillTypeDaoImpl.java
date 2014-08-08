package com.exadel.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.exadel.dao.SkillTypeDao;
import com.exadel.model.entity.student.SkillType;
@Repository
public class SkillTypeDaoImpl  extends GenericDaoImpl<SkillType> implements SkillTypeDao{

	@SuppressWarnings("unchecked")
	public List<SkillType> getAll() {
		return getSessionFactory().getCurrentSession().createQuery("from SkillType").list();
	}

	public SkillType find(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}