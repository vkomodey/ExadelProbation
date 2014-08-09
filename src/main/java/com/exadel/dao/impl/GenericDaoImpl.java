package com.exadel.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.exadel.dao.GenericDao;

public abstract class GenericDaoImpl<ENTITY> extends HibernateDaoSupport
		implements GenericDao<ENTITY> {
	protected Type type;

	/**
	 * stolen from jackson TypeReference constructor
	 */
	protected GenericDaoImpl() {
		Type superClass = getClass().getGenericSuperclass();
		if (superClass instanceof Class<?>) { // sanity check, should never happen
			throw new IllegalArgumentException(
					"Internal error: TypeReference constructed without actual type information");
		}
		type = ((ParameterizedType) superClass).getActualTypeArguments()[0];
	}

	@SuppressWarnings("unchecked")
	public ENTITY find(long id) {
		return (ENTITY) getSessionFactory().getCurrentSession().load(
				type.getClass(), id);
	}

	@SuppressWarnings("unchecked")
	public List<ENTITY> getAll() {
		return (List<ENTITY>) getSessionFactory().getCurrentSession()
				.createQuery("from " + type.toString());
	}

	@Autowired
	public void init(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	public void save(ENTITY entity) {
		getSessionFactory().getCurrentSession().saveOrUpdate(entity);
	}

	public void saveEntity(Object o) {
		getSessionFactory().getCurrentSession().saveOrUpdate(o);
	}
}
