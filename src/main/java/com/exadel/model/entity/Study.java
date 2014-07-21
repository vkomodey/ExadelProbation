package com.exadel.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Embeddable
public class Study {
    private int graduate_year;
    private String university, faculty, specialty, course_group;
    private List<StudentExams> exams;
    
    @OneToMany(cascade=CascadeType.ALL,orphanRemoval=true)
    @JoinColumn(name="student_fk")
    public List<StudentExams> getExams() {
		return exams;
	}

	public void setExams(List<StudentExams> exams) {
		this.exams = exams;
	}

	public Study() {
    }

    public Study(int student_id, int graduate_year, String university, String faculty, String specialty, String course_group) {

        this.graduate_year = graduate_year;
        this.university = university;
        this.faculty = faculty;
        this.specialty = specialty;
        this.course_group = course_group;
    }

    @Column(name = "graduate_year")
    public int getGraduate_year() {
        return graduate_year;
    }

    public void setGraduate_year(int graduate_year) {
        this.graduate_year = graduate_year;
    }

    @Column(name = "university")
    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    @Column(name = "faculty")
    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    @Column(name = "specialty")
    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Column(name = "course_group")
    public String getCourse_group() {
        return course_group;
    }

    public void setCourse_group(String course_group) {
        this.course_group = course_group;
    }

}
