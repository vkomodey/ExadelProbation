package com.exadel.model.entity.government;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.exadel.model.constants.SpringSecurityRole;
import com.exadel.model.entity.student.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
public class Curator extends FeedbackAble {
	@Override
	@Transient
	@JsonIgnore
	public String getRole(){
		return SpringSecurityRole.CURATOR;
	}

    private List<Student> students;

    @OneToMany(mappedBy = "curator")
    @JsonIgnore
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
