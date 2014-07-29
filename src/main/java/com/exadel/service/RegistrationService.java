package com.exadel.service;

import com.exadel.model.entity.view.RegistrationView;

public interface RegistrationService {
	public void registerAnyone(RegistrationView view);
	public void registerStudent(RegistrationView view);
}
