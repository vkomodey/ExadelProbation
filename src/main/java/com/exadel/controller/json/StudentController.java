package com.exadel.controller.json;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import com.exadel.model.entity.view.StudentView;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.exadel.model.constants.EnglishEnum;
import com.exadel.model.constants.SpringSecurityRole;
import com.exadel.model.constants.StudentStateEnum;
import com.exadel.model.entity.Feedback;
import com.exadel.model.entity.student.ExadelPractice;
import com.exadel.model.entity.student.ExadelWork;
import com.exadel.model.entity.student.Skill;
import com.exadel.model.entity.student.SkillType;
import com.exadel.model.entity.student.Student;
import com.exadel.model.entity.student.StudentExams;
import com.exadel.model.entity.student.Study;
import com.exadel.model.entity.student.Technology;
import com.exadel.service.CuratorService;
import com.exadel.service.StudentService;
import com.exadel.service.UserService;

@Controller
public class StudentController {
	@Autowired
	StudentService service;
	@Autowired
	UserService userService;
    @Autowired
    CuratorService curatorService;
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
	public @ResponseBody Student getStudent(@PathVariable("id") String idString){
		long id=Long.parseLong(idString);
		logger.info("real student fetching");
		Student student=service.findById(id);
		logger.info("real student sending");
		return student;
	}
	
	@RequestMapping(value=RestURIConstants.GET_ALL_STUDENT,method=RequestMethod.GET)
	public @ResponseBody List<Student> getAllStudents(Principal user){
		logger.info("student list fetching");
		List<Student> list;
        List<SimpleGrantedAuthority> authorities = (List<SimpleGrantedAuthority>)SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getAuthorities();

        String role = authorities.get(0).toString();
        if(role.equals(SpringSecurityRole.CURATOR)){
			list=service.getSupervised(userService.findByLogin(user.getName()).getId());
		}
		else{
		    list=service.getAll();
		}
		logger.info("student list sending");
        int inc=0;
        for(Student item : list){
            item.setFirstName("sutud_first_name "+inc);
            item.setSecondName("stud_second_name"+inc);
            item.setSurname("stud_surname"+inc);
            inc++;
            System.out.println(inc);
        }
		return list;
	}
	
	@RequestMapping(value=RestURIConstants.DUMMY_STUDENTARRAY,method=RequestMethod.GET)
	public @ResponseBody List<Student> getDummyStudentArray(){
		logger.info("dummy student array sending");
		ArrayList<Student> ar=new ArrayList<Student>();
		for(int i=0;i<5;i++)
			ar.add(buildDummy());
		return ar;
	}

    @RequestMapping(value = RestURIConstants.EDIT_STUDENT_INFO, method = RequestMethod.POST)
    public @ResponseBody void editStudentInfo(@RequestBody String str, @PathVariable("id") Long id) {
        logger.info("Start editing student info.");
        ObjectMapper mapper = new ObjectMapper();
        try {
            StudentView view =  mapper.readValue(str,StudentView.class);
            service.modify(view,id);
            logger.info("edited"+id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
