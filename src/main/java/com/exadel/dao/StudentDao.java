package com.exadel.dao;

import java.util.List;

import com.exadel.model.entity.Feedback;
import com.exadel.model.entity.StudentLog;
import com.exadel.model.entity.student.Student;

public interface StudentDao extends GenericLivingDao<Student> {
    void updateByMerge(Student st);
	void detach(Student st);
	public List<String> getFaculties();
	public List<String> getUniversities();
	public List<Integer> getStudyEndYears();
	List<String> getEmails(List<Long> students_id);
    List<Feedback> findAllForStud(Student stud);
    List<StudentLog> findLogsForStud(Student stud);
}