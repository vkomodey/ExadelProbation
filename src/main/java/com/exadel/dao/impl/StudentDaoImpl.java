package com.exadel.dao.impl;

import java.util.List;

import com.exadel.dao.GenericDao;
import com.exadel.dao.GenericLivingDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.exadel.dao.StudentDao;
import com.exadel.model.entity.student.Student;
import org.springframework.transaction.annotation.Transactional;

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
    public void updateStudent(Student st){
        try{
        Session session = getSessionFactory().getCurrentSession();
        session.update(st);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
