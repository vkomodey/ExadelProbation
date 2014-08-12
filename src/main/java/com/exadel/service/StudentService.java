package com.exadel.service;

import java.util.List;

import com.exadel.model.entity.student.Student;
import com.exadel.model.view.*;

public interface StudentService extends GenericLivingService<Student> {
	public List<FeedbackView> getFeedbacksForStudentByStudId(long id);
    public List<StudentStateView> getStudentStateList(long id);
	public void saveNewFeedbackForStudentByStudId(FeedbackView feedback,long id, String creator);
	public List<StudentView> getAll();
    void modify(StudentView entity,long id);
	/*public CompositeStudentFeedbackView generateStudentViewForUser(long id,
			String role);*/
	public List<Student> getAll(List<Long> ids);
    public void attachStudentToCurator(long id, long curator_id);
    public void attachStudentsToCurators(List<Long> students_id, List<Long> curators_id);
    public List<String> getAllEmailAddressesOfStudents(List<Long> students_id);
}
