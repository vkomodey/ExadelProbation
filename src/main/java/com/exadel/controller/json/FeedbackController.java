package com.exadel.controller.json;

import java.io.IOException;
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

import com.exadel.controller.json.constants.StudURI;
import com.exadel.model.view.FeedbackView;
import com.exadel.service.StudentService;
import com.exadel.util.SecurityUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class FeedbackController {

	private static Logger logger = LoggerFactory
			.getLogger(FeedbackController.class);
	@Autowired
	StudentService service;

	@RequestMapping(value = StudURI.GET_FEEDBACK_ARRAY, method = RequestMethod.GET)
	public @ResponseBody List<FeedbackView> returnFeedbackList(
			@PathVariable("id") String id, Principal user) {

		logger.info("Sending feedback list");
		String role = SecurityUtil.getRole();
		long studId = Long.parseLong(id);
		if (SecurityUtil.isFeedbackableNotAdmin(role)) {
			return service.getFeedbacksForStudentByCurator(studId,
					user.getName());
		} else {
			return service.getFeedbacksForStudent(studId);
		}

	}

	@RequestMapping(value = StudURI.PUSH_FEEDBACK, method = RequestMethod.POST)
	public @ResponseBody void saveFeedback(@RequestBody String str,
			@PathVariable("id") long studId, Principal user) throws IOException {
		logger.info("Start saving feedback.");
		ObjectMapper mapper = new ObjectMapper();
        FeedbackView feedback = mapper.readValue(str, FeedbackView.class);
        service.saveNewFeedbackForStudentByStudId(feedback, studId,
                user.getName());
	}

}
