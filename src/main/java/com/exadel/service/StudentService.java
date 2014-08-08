package com.exadel.service;

import java.util.List;
import java.util.Map;

import com.exadel.model.entity.student.Student;
import com.exadel.model.view.CompositeStudentFeedbackView;
import com.exadel.model.view.FeedbackView;
import com.exadel.model.view.FileExportView;
import com.exadel.model.view.StudentView;

public interface StudentService extends GenericLivingService<Student> {
	public List<FeedbackView> getFeedbacksForStudentByStudId(long id);
	public void saveNewFeedbackForStudentByStudId(FeedbackView feedback,long id, String creator);
	public List<Student> getAll();
    void modify(StudentView entity,long id);
	public CompositeStudentFeedbackView generateStudentViewForUser(long id,
			String role);
	public List<Student> getFiltered(Map<String, String> params);
	public List<Student> getAll(List<FileExportView> ids);
    //public List<Student> getAll(List<Long> ids);
    public void attachStudentTo(long id, long curator_id);
    public void attachStudentsToCurators(List<Long> listId, List<Long> curators_id);
}
