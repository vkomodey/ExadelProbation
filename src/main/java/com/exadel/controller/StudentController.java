package com.exadel.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exadel.model.entity.ExadelPractice;
import com.exadel.model.entity.ExadelWork;
import com.exadel.model.entity.Feedback;
import com.exadel.model.entity.Skill;
import com.exadel.model.entity.SkillType;
import com.exadel.model.entity.Student;
import com.exadel.model.entity.StudentExams;
import com.exadel.model.entity.Study;
import com.exadel.model.entity.Technology;
import com.exadel.model.enums.StudentStateEnum;

@Controller
public class StudentController {
	public static Logger logger=LoggerFactory.getLogger(StudentController.class);
	@RequestMapping(value=RestURIConstants.DUMMY_STUDENT,method=RequestMethod.GET)
	public @ResponseBody Student getDummyStudent(){
		logger.info("dummy student sending");
		Student stud=new Student();
		stud.setFirstName("Wasya");
		stud.setLogin("wasya");
		stud.setSecondName("wasyan");
		stud.setState(StudentStateEnum.PROBATION);
		stud.setSurname("wasyanchik");
		stud.setWork(new ExadelWork());
		stud.setPractice(new ExadelPractice());
		stud.setStudy(new Study());
		stud.getStudy().setExams(new ArrayList<StudentExams>());
		stud.getStudy().getExams().add(new StudentExams());
		stud.getSkillSet().add(new Skill(new SkillType("fapskill")));
		stud.getWork().getProjectTechnologies().add(new Technology("fap_technology"));
		stud.getFeedback().add(new Feedback());
		return stud;
	}
}
