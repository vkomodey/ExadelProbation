package com.exadel.util;

import com.exadel.model.entity.student.Student;

public class LazyUtil {

	public static void lazyTouchWithTechs(Student student) {
		LazyUtil.lazyTouch(student);
	    if(student.getWork()!=null){
	    student.getWork().getCurrentUsedTechnologies().size();
	    student.getWork().getDesiredUsedTechnologies().size();
	    }
	}

	// wake up all students, they so laaaazy. denis - glazier//
	public static void lazyTouch(Student student){
	    student.getStudy().getExams().size();
	    student.getSkillSet().size();
	}

}
