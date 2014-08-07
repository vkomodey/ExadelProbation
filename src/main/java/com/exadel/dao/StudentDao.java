package com.exadel.dao;

import java.util.List;

import com.exadel.model.entity.student.Student;

public interface StudentDao extends GenericLivingDao<Student> {
    void updateByMerge(Student st);
	void detach(Student st);
    void attachStudentTo(long id, long curator_id);
	public List<String> getFaculties();
	public List<String> getUniversities();
	public List<Integer> getStudyEndYears();
}