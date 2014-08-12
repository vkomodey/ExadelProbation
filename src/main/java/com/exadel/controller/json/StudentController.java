package com.exadel.controller.json;

import com.exadel.controller.json.constants.MeURI;
import com.exadel.controller.json.constants.StudURI;
import com.exadel.model.constants.SpringSecurityRole;
import com.exadel.model.entity.student.Student;
import com.exadel.model.view.FeedbackView;
import com.exadel.model.view.StudentView;
import com.exadel.service.CuratorService;
import com.exadel.service.ProjectService;
import com.exadel.service.StudentService;
import com.exadel.service.UserService;
import com.exadel.util.JsonUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.StringWriter;
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
    @Autowired
    ProjectService projectService;
	
	@RequestMapping(value = StudURI.ATTACH_STUDENT, method = RequestMethod.POST)
    public @ResponseBody void attachStudentToCurator(@PathVariable String id,
                                              @PathVariable String curator_id){
        logger.info("start attache student with id " + id + " with curator, which id is " + curator_id);
        studentService.attachStudentToCurator(Long.parseLong(id), Long.parseLong(curator_id));
        logger.info("attaching success");
    }

    @RequestMapping(value = StudURI.ATTACH_STUDENTS_TO_CURATORS, method = RequestMethod.POST)
    public @ResponseBody void attachStudentsToCurators(@RequestBody String json,ObjectMapper om) throws IOException{
    	JsonNode rootnode=om.readTree(json);
    	JsonNode studnode=rootnode.path("studsId");
    	JsonNode curnode=rootnode.path("cursId");
    	List<Long> stud=om.readValue(studnode.traverse(), JsonUtil.listOfLongTypeRef);
        List<Long> cur=om.readValue(curnode.traverse(), JsonUtil.listOfLongTypeRef);
        studentService.attachStudentsToCurators(stud, cur);
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
	public @ResponseBody StudentView getMe(Principal user){
		logger.info("real student fetching");
		Student student=service.findByLogin(user.getName());
		logger.info("real student sending");
		return student.toView();
	}

    @RequestMapping(value=StudURI.GET_STUDENT,method=RequestMethod.GET)
	public @ResponseBody String getStudent(@PathVariable("id") String idString,ObjectMapper om) throws IOException{
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
		//CompositeStudentFeedbackView view=service.generateStudentViewForUser(id,role);
		StudentView info=service.findById(id).toView();
		List<FeedbackView> feedbacks=service.getFeedbacksForStudentByStudId(id);
		StringWriter sw=new StringWriter();
		JsonGenerator jg=om.getFactory().createGenerator(sw);
		jg.writeStartObject();
		jg.writeObjectField("info", info);
		jg.writeObjectField("feedbacks", feedbacks);
		jg.writeEndObject();
		jg.close();
		logger.info("student info sending");
		return sw.toString();
	}

    @RequestMapping(value = StudURI.GET_PROJECT_HISTORY, method = RequestMethod.GET)
    public @ResponseBody List<String> getProjectHistory(@PathVariable("id") long id){

        return projectService.getProjectHistory(id);
    }
}
