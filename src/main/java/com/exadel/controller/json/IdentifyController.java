package com.exadel.controller.json;

import com.exadel.controller.json.constants.MeURI;
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
public class IdentifyController {
	@Autowired
	UserService service;

	private static Logger logger = LoggerFactory
			.getLogger(IdentifyController.class);

	@RequestMapping(value = MeURI.IDENTIFY_ROLE, method = RequestMethod.GET)
	public @ResponseBody String identifyUserRole(Principal user) {
		logger.info("Start identifying user role.");
		@SuppressWarnings("unchecked")
		List<SimpleGrantedAuthority> simpleGrantedAuthorities = (List<SimpleGrantedAuthority>) (SecurityContextHolder
				.getContext().getAuthentication().getAuthorities());
		String role = simpleGrantedAuthorities.get(0).getAuthority();
		logger.info("identified as " + role);
		return role;
	}
	@RequestMapping(value = MeURI.IDENTIFY_NAME, method = RequestMethod.GET)
	public @ResponseBody String getUserName(Principal user) {
		return service.findByLogin(user.getName()).getFullName();
	}
}
