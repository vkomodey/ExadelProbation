package com.exadel.controller.json;

import com.exadel.controller.json.constants.MeURI;
import com.exadel.service.UserService;
import com.exadel.util.SecurityUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class IdentifyController {
	@Autowired
	UserService service;

	private static Logger logger = LoggerFactory
			.getLogger(IdentifyController.class);

	@RequestMapping(value = MeURI.IDENTIFY_ROLE, method = RequestMethod.GET)
	public @ResponseBody String identifyUserRole() {
		logger.info("Start identifying user role.");
		String role = SecurityUtil.getRole();
		logger.info("identified as " + role);
		return role;
	}
	@RequestMapping(value = MeURI.IDENTIFY_NAME, method = RequestMethod.GET)
	public @ResponseBody String getUserName(Principal user) {
		return service.findByLogin(user.getName()).getFullName();
	}
}
