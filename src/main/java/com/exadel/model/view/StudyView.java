package com.exadel.model.view;

import java.util.Map;


public class StudyView {
	private Integer graduate_year;
    public StudyView() {
	}
	private String university, faculty, specialty, course_group;
    private Map<String,Double> exams;
	public static final String SEM_PREFIX="sem";
	public static final Integer EXAM_COUNT =10;
	public static final Integer EXAM_START_VALUE =3;
	public Integer getGraduate_year() {
		return graduate_year;
	}
	public String getUniversity() {
		return university;
	}
	public String getFaculty() {
		return faculty;
	}
	public String getSpecialty() {
		return specialty;
	}
	public String getCourse_group() {
		return course_group;
	}
	public Map<String, Double> getExams() {
		return exams;
	}
	public void setGraduate_year(Integer graduate_year) {
		this.graduate_year = graduate_year;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public void setCourse_group(String course_group) {
		this.course_group = course_group;
	}
	public void setExams(Map<String, Double> exams) {
		this.exams = exams;
	}
}
