package com.exadel.service;

import com.exadel.model.entity.student.Student;
import com.exadel.model.entity.view.FeedbackView;

import java.util.List;

public interface StudentService extends GenericLivingService<Student> {
	public List<FeedbackView> getFeedbacksForStudentByStudId(long id);
	public void saveNewFeedbackForStudentByStudId(FeedbackView feedback,long id, String creator);
}
