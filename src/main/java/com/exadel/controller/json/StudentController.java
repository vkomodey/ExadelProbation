package com.exadel.controller.json;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exadel.controller.json.constants.MeURI;
import com.exadel.controller.json.constants.StudURI;
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
import com.exadel.model.entity.view.CompositeStudentFeedbackView;
import com.exadel.model.entity.view.StudentView;
import com.exadel.service.CuratorService;
import com.exadel.service.StudentService;
import com.exadel.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class StudentController {
	@Autowired
	StudentService service;
	@Autowired
	UserService userService;
    @Autowired
    CuratorService curatorService;
    @Autowired
    StudentService studentService;
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
		stud.getFeedback().add(new Feedback());
		stud.setEnglish(EnglishEnum.advanced);
		return stud;
	}
	@RequestMapping(value=StudURI.DUMMY_STUDENT,method=RequestMethod.GET)
	public @ResponseBody Student getDummyStudent(){
		logger.info("dummy student sending");
		return buildDummy();
	}
	@RequestMapping(value=StudURI.GET_STUDENT,method=RequestMethod.GET)
	public @ResponseBody CompositeStudentFeedbackView getStudent(@PathVariable("id") String idString){
		logger.info("caller role searching");
		@SuppressWarnings("unchecked")
		List<SimpleGrantedAuthority> authorities = (List<SimpleGrantedAuthority>)SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getAuthorities();

        String role = authorities.get(0).toString();
        logger.info("caller role - " + role);
        long id=Long.parseLong(idString);
		logger.info("composite student view fetching");
		CompositeStudentFeedbackView view=service.generateStudentViewForUser(id,role);
		
		logger.info("student info sending");
		return view;
	}
	
	@RequestMapping(value=StudURI.GET_ALL_STUDENT,method=RequestMethod.GET)
	public @ResponseBody List<Student> getAllStudents(Principal user){
		logger.info("student list fetching");
		List<Student> list;
        @SuppressWarnings("unchecked")
		List<SimpleGrantedAuthority> authorities = (List<SimpleGrantedAuthority>)SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getAuthorities();

        String role = authorities.get(0).toString();
        if(role.equals(SpringSecurityRole.CURATOR)){
			list=curatorService.getSupervised(userService.findByLogin(user.getName()).getId());
		}
		else{
		    list=service.getAll();
		}
		logger.info("student list sending");
/*        int inc=0;
        for(Student item : list){
            item.setFirstName("sutud_first_name "+inc);
            item.setSecondName("stud_second_name"+inc);
            item.setSurname("stud_surname"+inc);
            inc++;
            System.out.println(inc);
        }*/
		return list;
	}
	
	@RequestMapping(value=StudURI.DUMMY_STUDENTARRAY,method=RequestMethod.GET)
	public @ResponseBody List<Student> getDummyStudentArray(){
		logger.info("dummy student array sending");
		ArrayList<Student> ar=new ArrayList<Student>();
		for(int i=0;i<10;i++)
			ar.add(buildDummy());
		return ar;
	}

    @RequestMapping(value = StudURI.EDIT_STUDENT_INFO, method = RequestMethod.POST)
    public @ResponseBody void editStudentInfo(@RequestBody String str, @PathVariable("id") Long id) throws IOException {
        logger.info("Start editing student info.");
        ObjectMapper mapper = new ObjectMapper();
        StudentView view =  mapper.readValue(str,StudentView.class);
        service.modify(view, id);
        logger.info("edited"+id);
    }
    
	@RequestMapping(value=MeURI.GET_ME,method=RequestMethod.GET)
	public @ResponseBody Student getMe(Principal user){
		logger.info("real student fetching");
		Student student=service.findByLogin(user.getName());
		logger.info("real student sending");
		return student;
	}

    @RequestMapping(value = StudURI.ATTACH_STUDENT, method = RequestMethod.POST)
    public @ResponseBody void attachStudentTo(@PathVariable String id,
                                              @PathVariable String curator_id){
        logger.info("start attache student with id " + id + " with curator, which id is " + curator_id);
        studentService.attachStudentTo(Long.parseLong(id), Long.parseLong(curator_id));
        logger.info("attaching success");
    }
}
