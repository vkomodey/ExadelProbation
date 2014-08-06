package com.exadel.dao.impl;

import java.util.List;

import com.exadel.model.entity.government.Curator;

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
    @SuppressWarnings("unchecked")
    public List<Student> getSupervised(long id){
        return getSessionFactory().getCurrentSession().createQuery("from Student where curator.id=:id").setLong("id", id).list();
    }
    public void updateByMerge(Student st){
        getSessionFactory().getCurrentSession().merge(st);
    }

	public void detach(Student st) {
		getSessionFactory().getCurrentSession().evict(st);
	}

    public void attachStudentTo(long id, long curator_id){
        Session session = getSessionFactory().getCurrentSession();
        Student student = (Student)session.get(Student.class, id);
        Curator curator = (Curator)session.get(Curator.class, curator_id);
        student.setCurator(curator);
        session.update("student", student);
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
	public List<Long> getStudyEndYears() {
		// TODO Auto-generated method stub
		return getSessionFactory().getCurrentSession().createQuery("select distinct s.study.graduate_year from Student s").list();
	}
}