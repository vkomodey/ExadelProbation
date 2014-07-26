package com.exadel.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exadel.model.entity.student.Student;
import com.exadel.model.entity.view.FeedbackView;
import com.exadel.service.StudentService;
@Service
public class StudentServiceImpl extends GenericLivingServiceImpl<Student> implements StudentService{
	@Transactional
	public List<FeedbackView> getFeedbacksForStudentByStudId(long id) {
		return null;
	}

	@Transactional
	public void saveNewFeedbackForStudentByStudId(FeedbackView feedback, long id) {
		// TODO Auto-generated method stub
		
	}
}
