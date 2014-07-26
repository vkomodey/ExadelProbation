package com.exadel.model.entity.student;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Embeddable
public class Study {
    private Integer graduate_year;
    private String university, faculty, specialty, course_group;
    private List<StudentExams> exams;
    
    public Study() {
		this.setExams(new ArrayList<StudentExams>());
    }

	public Study(Integer graduate_year, String university, String faculty, String specialty, String course_group) {

        this.graduate_year = graduate_year;
        this.university = university;
        this.faculty = faculty;
        this.specialty = specialty;
        this.course_group = course_group;
        this.exams=new ArrayList<StudentExams>();
    }

    @Column(name = "course_group")
	public String getCourse_group() {
	    return course_group;
	}

    @OneToMany(cascade=CascadeType.ALL,orphanRemoval=true)
    @JoinColumn(name="student_fk")
    public List<StudentExams> getExams() {
		return exams;
	}

    @Column(name = "faculty")
	public String getFaculty() {
	    return faculty;
	}

	@Column(name = "graduate_year")
    public Integer getGraduate_year() {
        return graduate_year;
    }

	@Column(name = "specialty")
	public String getSpecialty() {
	    return specialty;
	}

	@Column(name = "university")
    public String getUniversity() {
        return university;
    }

    public void setCourse_group(String course_group) {
        this.course_group = course_group;
    }

    public void setExams(List<StudentExams> exams) {
		this.exams = exams;
	}

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

	public void setGraduate_year(Integer graduate_year) {
	    this.graduate_year = graduate_year;
	}

	public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

	public void setUniversity(String university) {
	    this.university = university;
	}

}
