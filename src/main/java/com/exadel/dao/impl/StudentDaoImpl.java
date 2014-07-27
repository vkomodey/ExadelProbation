package com.exadel.dao.impl;

import com.exadel.dao.StudentDao;
import com.exadel.model.entity.student.Student;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoImpl extends GenericLivingDaoImpl<Student> implements
		StudentDao {
	public Student find(long id) {
		return (Student) getSessionFactory().getCurrentSession().get(
				Student.class, id);
	}

	public Student find(String login) {
		Session session = getSessionFactory().getCurrentSession();
		Student stud = (Student) session.bySimpleNaturalId(Student.class).load(
				"login");
		return stud;
	}
}
