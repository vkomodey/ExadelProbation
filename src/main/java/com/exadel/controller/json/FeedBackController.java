package com.exadel.controller.json;

import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exadel.model.entity.view.FeedbackView;
import com.exadel.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class FeedBackController {

	public static Logger logger = LoggerFactory
			.getLogger(FeedBackController.class);
	@Autowired
	StudentService service;

	@RequestMapping(value = RestURIConstants.GET_FEEDBACK_ARRAY, method = RequestMethod.GET)
	public @ResponseBody List<FeedbackView> returnFeedbackList(
			@PathVariable("id") String id) {
		logger.info("Sending feedback list");
		try {
			long studId = Long.parseLong(id);
			return service.getFeedbacksForStudentByStudId(studId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping(value = RestURIConstants.PUSH_FEEDBACK, method = RequestMethod.POST)
	public @ResponseBody void saveFeedback(@RequestBody String str,
			@PathVariable("id") long studId, Principal user) {
		logger.info("Start saving feedback.");
		ObjectMapper mapper = new ObjectMapper();
		try {
			FeedbackView feedback = mapper.readValue(str, FeedbackView.class);
			service.saveNewFeedbackForStudentByStudId(feedback, studId,
					user.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
