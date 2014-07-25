package com.exadel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.exadel.dao.impl.StudentDaoImpl;
import com.exadel.model.entity.student.Student;

@Transactional
public interface StudentService extends GenericLivingService<Student> {
	public List getFeedbacksForStudentByStudId(long id);
}
