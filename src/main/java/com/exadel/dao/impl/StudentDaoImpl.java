package com.exadel.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.exadel.dao.StudentDao;
import com.exadel.model.entity.student.Student;

@Repository
public class StudentDaoImpl extends GenericLivingDaoImpl<Student> implements
		StudentDao {

	public Student find(String login) {
		Session session = getSessionFactory().getCurrentSession();
		Student stud = (Student) session.bySimpleNaturalId(Student.class).load(
				login);
		return stud;
	}

	public void updateByMerge(Student st) {
		getSessionFactory().getCurrentSession().merge(st);
	}

	public void detach(Student st) {
		getSessionFactory().getCurrentSession().evict(st);
	}

	@SuppressWarnings("unchecked")
	public List<String> getFaculties() {
		// TODO Auto-generated method stub
		return getSessionFactory().getCurrentSession()
				.createQuery("select distinct s.study.faculty from Student s")
				.list();
	}

	@SuppressWarnings("unchecked")
	public List<String> getUniversities() {
		// TODO Auto-generated method stub
		return getSessionFactory()
				.getCurrentSession()
				.createQuery(
						"select distinct s.study.university from Student s")
				.list();
	}

	@SuppressWarnings("unchecked")
	public List<Integer> getStudyEndYears() {
		// TODO Auto-generated method stub
		return getSessionFactory()
				.getCurrentSession()
				.createQuery(
						"select distinct s.study.graduate_year from Student s")
				.list();
	}

	@SuppressWarnings("unchecked")
	public List<String> getEmails(List<Long> students_id) {
		return getSessionFactory()
				.getCurrentSession()
				.createQuery(
						"select s.email from Student s where s.id in (:idlist)")
				.setParameterList("idlist", students_id).list();
	}
}