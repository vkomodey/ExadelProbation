package com.exadel.util;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.exadel.model.constants.SpringSecurityRole;

public class SecurityUtil {
	public static boolean isFeedbackableNotAdmin(String role) {
		switch (role) {
		case SpringSecurityRole.CURATOR:
		case SpringSecurityRole.FEEDBACKER:
			return true;
		default:
			return false;
		}
	}
	@SuppressWarnings("unchecked")
	public static String getRole(){
		return ((List<SimpleGrantedAuthority>) (SecurityContextHolder
				.getContext().getAuthentication().getAuthorities())).get(0)
				.getAuthority();
		
	}
}
