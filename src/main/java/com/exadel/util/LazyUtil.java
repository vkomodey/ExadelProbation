package com.exadel.util;

import com.exadel.model.entity.Project;
import com.exadel.model.entity.student.Student;
import com.exadel.model.entity.student.Technology;

public class LazyUtil {

	public static void lazyTouchWithTechs(Student student) {
		LazyUtil.lazyTouch(student);
	    if(student.getWork()!=null){
	    student.getWork().getCurrentUsedTechnologies().size();
	    student.getWork().getDesiredUsedTechnologies().size();
	    student.getWork().getCurrentProjects().size();
	    }
	}

	// wake up all students, they so laaaazy. denis - vasya//
	public static void lazyTouch(Student student){
	    student.getStudy().getExams().size();
	    student.getSkillSet().size();
	    student.getWork().getCurrentProjects().size();
	    }

	public static void lazyTouchProject(Project project){
	    for(Student student:project.getStudents()){
	        student.getId();
	    }
	    for(Technology technology:project.getUsedTechnologies()){
	        technology.getId();
	    }
	}

}
