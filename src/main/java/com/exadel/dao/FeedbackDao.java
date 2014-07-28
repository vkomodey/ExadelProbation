package com.exadel.dao;

import com.exadel.model.entity.Feedback;
import com.exadel.model.entity.student.Student;

import java.util.List;

public interface FeedbackDao extends GenericDao<Feedback> {

	List<Feedback> findAllForStud(Student stud);

}
