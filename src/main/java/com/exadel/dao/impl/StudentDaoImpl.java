package com.exadel.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.exadel.dao.StudentDao;
import com.exadel.model.entity.student.Student;

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
				login);
		return stud;
	}

	@SuppressWarnings("unchecked")
	public List<Student> getAll() {
		return getSessionFactory().getCurrentSession().createQuery("from Student").list();
	}

    public void updateByMerge(Student st){
        getSessionFactory().getCurrentSession().merge(st);
    }

	public void detach(Student st) {
		getSessionFactory().getCurrentSession().evict(st);
	}

	@SuppressWarnings("unchecked")
	public List<String> getFaculties() {
		// TODO Auto-generated method stub
		return getSessionFactory().getCurrentSession().createQuery("select distinct s.study.faculty from Student s").list();
	}

	@SuppressWarnings("unchecked")
	public List<String> getUniversities() {
		// TODO Auto-generated method stub
		return getSessionFactory().getCurrentSession().createQuery("select distinct s.study.university from Student s").list();
	}

	@SuppressWarnings("unchecked")
	public List<Integer> getStudyEndYears() {
		// TODO Auto-generated method stub
		return getSessionFactory().getCurrentSession().createQuery("select distinct s.study.graduate_year from Student s").list();
	}
}