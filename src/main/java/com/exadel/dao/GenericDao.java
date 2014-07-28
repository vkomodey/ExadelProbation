package com.exadel.dao;

import java.util.List;

import com.exadel.model.entity.student.Student;


public interface GenericDao<ENTITY> {

	public abstract ENTITY find(long id);

	public abstract void save(ENTITY entity);

	public abstract List<Student> getAll();

}