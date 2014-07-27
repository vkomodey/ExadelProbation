package com.exadel.controller.json;

import com.exadel.model.constants.EnglishEnum;
import com.exadel.model.constants.StudentStateEnum;
import com.exadel.model.entity.Feedback;
import com.exadel.model.entity.student.*;
import com.exadel.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {
	@Autowired
	StudentService service;
	private static Logger logger=LoggerFactory.getLogger(StudentController.class);
	private Student buildDummy(){
		logger.info("dummy student build");
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
		stud.setEnglish(EnglishEnum.advanced);
		return stud;
	}
	@RequestMapping(value=RestURIConstants.DUMMY_STUDENT,method=RequestMethod.GET)
	public @ResponseBody Student getDummyStudent(){
		logger.info("dummy student sending");
		return buildDummy();
	}
	@RequestMapping(value=RestURIConstants.GET_STUDENT,method=RequestMethod.GET)
	public @ResponseBody Student getDummyStudent(@PathVariable("id") String idString){
		long id=Long.parseLong(idString);
		logger.info("real student fetching");
		Student student=service.findById(id);
		logger.info("real student sending");
		return student;
	}
	
	@RequestMapping(value=RestURIConstants.DUMMY_STUDENTARRAY,method=RequestMethod.GET)
	public @ResponseBody List<Student> getDummyStudentArray(){
		logger.info("dummy student array sending");
		ArrayList<Student> ar=new ArrayList<Student>();
		for(int i=0;i<5;i++)
			ar.add(buildDummy());
		return ar;
	}
}
