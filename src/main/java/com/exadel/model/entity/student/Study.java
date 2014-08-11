package com.exadel.model.entity.student;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.OneToMany;

import com.exadel.model.view.StudyView;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;


@Embeddable
public class Study {
    private Integer graduate_year;
    private String university, faculty, specialty, course_group;
    private List<StudentExams> exams;
    
    public Study() {
    }

	public Study(Integer graduate_year, String university, String faculty, String specialty, String course_group) {
        this.graduate_year = graduate_year;
        this.university = university;
        this.faculty = faculty;
        this.specialty = specialty;
        this.course_group = course_group;
    }

    @Column(name = "course_group")
	public String getCourse_group() {
	    return course_group;
	}

    @OneToMany(cascade=CascadeType.ALL,orphanRemoval=true,mappedBy = "student")
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
	public StudyView toView(){
		StudyView view=new StudyView();
		view.setCourse_group(this.getCourse_group());
		view.setFaculty(this.getFaculty());
		view.setGraduate_year(this.getGraduate_year());
		view.setSpecialty(this.getSpecialty());
		view.setUniversity(this.getUniversity());
		view.setExams(new TreeMap<String,Double>());
		for(Integer i=StudyView.EXAM_START_VALUE;i<=StudyView.EXAM_COUNT;i++){
			view.getExams().put(StudyView.SEM_PREFIX+i.toString(),null);
		}
		for(StudentExams se:this.getExams()){
			view.getExams().put(StudyView.SEM_PREFIX+se.getSemester().toString(), se.getGrade());
		}
		return view;
	}
	public void fromView(StudyView view){
		this.setCourse_group(view.getCourse_group());
		this.setFaculty(view.getFaculty());
		this.setGraduate_year(view.getGraduate_year());
		this.setSpecialty(view.getSpecialty());
		this.setUniversity(view.getUniversity());
		for (Entry<String,Double> seview : view.getExams().entrySet()) {
			StudentExams se=new StudentExams();
			se.setGrade(seview.getValue());
			Integer sem=Integer.parseInt(seview.getKey().replace(StudyView.SEM_PREFIX, ""));
			se.setSemester(sem);
			this.getExams().add(se);
		}
	}
}
