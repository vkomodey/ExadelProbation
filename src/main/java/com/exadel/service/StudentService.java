package com.exadel.service;

import java.util.List;

import com.exadel.model.entity.student.Student;
import com.exadel.model.entity.view.CompositeStudentFeedbackView;
import com.exadel.model.entity.view.FeedbackView;
import com.exadel.model.entity.view.StudentView;

public interface StudentService extends GenericLivingService<Student> {
	public List<FeedbackView> getFeedbacksForStudentByStudId(long id);
	public void saveNewFeedbackForStudentByStudId(FeedbackView feedback,long id, String creator);
	public List<Student> getAll();
    public List<Student> getSupervised(long id);
    void modify(StudentView entity,long id);
	public CompositeStudentFeedbackView generateStudentViewForUser(long id,
			String role);
    public void attachStudentTo(long curatorId, long studentId);
}
