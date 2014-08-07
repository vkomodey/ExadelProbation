package com.exadel.model.entity.view;

import com.exadel.model.entity.User;

public class IdNameSurnamePersonView {
	private long id;
	private String firstname;
	private String surname;
	public IdNameSurnamePersonView(User user){
		this.setId(user.getId());
		this.setFirstname(user.getFirstName());
		this.setSurname(user.getSurname());
	}
	public IdNameSurnamePersonView(){

	}
	public long getId() {
		return id;
	}
	public String getFirstname() {
		return firstname;
	}
	public String getSurname() {
		return surname;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public void fromUser(User user){
		this.setId(user.getId());
		this.setFirstname(user.getFirstName());
		this.setSurname(user.getSurname());
	}
}
