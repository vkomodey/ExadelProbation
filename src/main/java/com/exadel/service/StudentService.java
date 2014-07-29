package com.exadel.service;

import java.util.List;

import com.exadel.model.entity.student.Student;
import com.exadel.model.entity.view.FeedbackView;

public interface StudentService extends GenericLivingService<Student> {
	public List<FeedbackView> getFeedbacksForStudentByStudId(long id);
	public void saveNewFeedbackForStudentByStudId(FeedbackView feedback,long id, String creator);
	public List<Student> getAll();
}
