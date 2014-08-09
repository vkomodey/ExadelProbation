package com.exadel.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.exadel.dao.CuratorDao;
import com.exadel.model.entity.government.Curator;
import com.exadel.model.entity.student.Student;

@Repository
public class CuratorDaoImpl extends GenericLivingDaoImpl<Curator> implements
		CuratorDao {

	@SuppressWarnings("unchecked")
	public List<Student> getSupervised(long CuratorId){
		return getSessionFactory()
				.getCurrentSession()
				.createQuery(
						"select j.student from StudentCuratorJoin j where j.curator.id=:id")
				.setLong("id", CuratorId).list();
    }

	@SuppressWarnings("unchecked")
	public List<Curator> getActive() {
		return getSessionFactory().getCurrentSession()
				.createQuery("select distinct j.curator from StudentCuratorJoin j").list();
	}

}
