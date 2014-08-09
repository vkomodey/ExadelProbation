package com.exadel.controller.json;

import com.exadel.controller.json.constants.MeURI;
import com.exadel.controller.json.constants.StudURI;
import com.exadel.model.constants.SpringSecurityRole;
import com.exadel.model.entity.student.Student;
import com.exadel.model.view.CompositeStudentFeedbackView;
import com.exadel.model.view.CompositeStudentsCuratorsView;
import com.exadel.model.view.StudentView;
import com.exadel.service.CuratorService;
import com.exadel.service.StudentService;
import com.exadel.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Controller
public class StudentController {
	private static Logger logger=LoggerFactory.getLogger(StudentController.class);
	@Autowired
    CuratorService curatorService;
    @Autowired
	StudentService service;
    @Autowired
    StudentService studentService;
	@Autowired
	UserService userService;
	
	@RequestMapping(value = StudURI.ATTACH_STUDENT, method = RequestMethod.POST)
    public @ResponseBody void attachStudentToCurator(@PathVariable String id,
                                              @PathVariable String curator_id){
        logger.info("start attache student with id " + id + " with curator, which id is " + curator_id);
        studentService.attachStudentTo(Long.parseLong(id), Long.parseLong(curator_id));
        logger.info("attaching success");
    }

    @RequestMapping(value = StudURI.ATTACH_STUDENTS_TO_CURATORS, method = RequestMethod.POST)
    public @ResponseBody void attachStudentsToCurators(@RequestBody String json) throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        CompositeStudentsCuratorsView view = objectMapper.readValue(json, CompositeStudentsCuratorsView.class);
        System.out.println(view.getCursId());
        System.out.println(view.getStudsId());
        studentService.attachStudentsToCurators(view.getStudsId(), view.getCursId());
    }

	@RequestMapping(value = StudURI.EDIT_STUDENT_INFO, method = RequestMethod.POST)
    public @ResponseBody void editStudentInfo(@RequestBody String str, @PathVariable("id") Long id) throws IOException {
        logger.info("Start editing student info.");
        ObjectMapper mapper = new ObjectMapper();
        StudentView view =  mapper.readValue(str,StudentView.class);
        service.modify(view, id);
        logger.info("edited"+id);
    }

    @RequestMapping(value=StudURI.GET_ALL_STUDENT,method=RequestMethod.GET)
	public @ResponseBody List<StudentView> getAllStudents(Principal user){
		logger.info("student list fetching");
		List<StudentView> studlist;
        @SuppressWarnings("unchecked")
		List<SimpleGrantedAuthority> authorities = (List<SimpleGrantedAuthority>)SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getAuthorities();

        String role = authorities.get(0).toString();
        if(role.equals(SpringSecurityRole.CURATOR)){
			studlist=curatorService.getSupervised(userService.findByLogin(user.getName()).getId());
		}
		else{
		    studlist=service.getAll();
		}
        logger.info("student list sending");
		return studlist;
	}
    
	@RequestMapping(value=MeURI.GET_ME,method=RequestMethod.GET)
	public @ResponseBody Student getMe(Principal user){
		logger.info("real student fetching");
		Student student=service.findByLogin(user.getName());
		logger.info("real student sending");
		return student;
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
}
