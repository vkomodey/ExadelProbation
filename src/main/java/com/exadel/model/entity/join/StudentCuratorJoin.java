package com.exadel.model.entity.join;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.exadel.model.entity.government.Curator;
import com.exadel.model.entity.student.Student;

@Entity
@Table(name="student_curator")
public class StudentCuratorJoin implements Serializable{
	private Calendar assignmentDate;
	private Curator curator;
	private Student student;

    @Column(name="assignment_date")
	public Calendar getAssignmentDate() {
		return assignmentDate;
	}
	@Id
	@ManyToOne
	@PrimaryKeyJoinColumn(name="curator", referencedColumnName="id")
	public Curator getCurator() {
		return curator;
	}
	@Id
	@ManyToOne
	@PrimaryKeyJoinColumn(name="student", referencedColumnName="id")
	public Student getStudent() {
		return student;
	}

    public void setAssignmentDate(Calendar assignmentDate) {
		this.assignmentDate = assignmentDate;
	}
	public void setCurator(Curator curator) {
		this.curator = curator;
	}
	public void setStudent(Student student) {
		this.student = student;
	}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentCuratorJoin join = (StudentCuratorJoin) o;

        if (!assignmentDate.equals(join.assignmentDate)) return false;
        if (!curator.equals(join.curator)) return false;
        if (!student.equals(join.student)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = assignmentDate.hashCode();
        result = 31 * result + curator.hashCode();
        result = 31 * result + student.hashCode();
        return result;
    }
}
