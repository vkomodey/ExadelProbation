package com.exadel.dao;

import java.util.List;

import com.exadel.model.entity.Feedback;
import com.exadel.model.entity.StudentLog;
import com.exadel.model.entity.student.Faculty;
import com.exadel.model.entity.student.Student;
import com.exadel.model.entity.student.University;

public interface StudentDao extends GenericLivingDao<Student> {
    void updateByMerge(Student st);
	void detach(Student st);
	public List<Faculty> getActiveFaculties();
	public List<University> getActiveUniversities();
	public List<Integer> getStudyEndYears();
	List<String> getEmails(List<Long> students_id);
    List<Feedback> findAllFeedback(Student stud);
    List<StudentLog> findLogsForStud(Student stud);
	List<Integer> getWorkhours();
}