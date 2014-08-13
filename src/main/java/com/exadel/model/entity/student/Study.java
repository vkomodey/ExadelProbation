package com.exadel.model.entity.student;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.exadel.model.view.StudyView;
import com.exadel.util.BuilderUtil;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;


@Embeddable
public class Study {
    private Integer graduate_year;
    private String specialty, course_group;
    private List<StudentExams> exams;
    private University university;
    private Faculty faculty;
    private final SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    public Study() {
    }

    @Column(name = "course_group")
	public String getCourse_group() {
	    return course_group;
	}

    @OneToMany(cascade=CascadeType.ALL,orphanRemoval=true,mappedBy = "student")
    public List<StudentExams> getExams() {
		return exams;
	}
    @OneToOne
    @JoinColumn(name = "faculty")
	public Faculty getFaculty() {
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
	@OneToOne
	@JoinColumn(name = "university")
    public University getUniversity() {
        return university;
    }

    public void setCourse_group(String course_group) {
        this.course_group = course_group;
    }

    public void setExams(List<StudentExams> exams) {
		this.exams = exams;
	}

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

	public void setGraduate_year(Integer graduate_year) {
	    this.graduate_year = graduate_year;
	}

	public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

	public void setUniversity(University university) {
	    this.university = university;
	}
	public StudyView toView(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
		StudyView view=new StudyView();
		view.setCourse_group(this.getCourse_group());
        if(this.getFaculty()!=null)
		    view.setFaculty(this.getFaculty().getName());
        else
            view.setFaculty("");
        if(this.getGraduate_year()!=null)
		    view.setGraduate_year(this.getGraduate_year());
        else
            view.setGraduate_year(Integer.parseInt(dateFormat.format(new java.util.Date())));
		view.setSpecialty(this.getSpecialty());
        if(this.getUniversity()!=null)
		    view.setUniversity(this.getUniversity().getName());
        else
            view.setUniversity("");
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
		this.setGraduate_year(view.getGraduate_year());
		this.setSpecialty(view.getSpecialty());
		for (Entry<String,Double> seview : view.getExams().entrySet()) {
            if(seview.getValue()!=null) {
                StudentExams se = new StudentExams();
                se.setGrade(seview.getValue());
                Integer sem = Integer.parseInt(seview.getKey().replace(StudyView.SEM_PREFIX, ""));
                se.setSemester(sem);
                this.getExams().add(se);
            }
		}
	}
}
