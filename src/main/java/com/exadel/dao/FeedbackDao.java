package com.exadel.dao;

import java.util.List;

import com.exadel.model.entity.Feedback;
import com.exadel.model.entity.student.Student;

public interface FeedbackDao extends GenericDao<Feedback> {

	List<Feedback> findAllForStud(Student stud);

}
