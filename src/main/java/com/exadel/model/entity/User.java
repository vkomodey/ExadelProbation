package com.exadel.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.NaturalId;

import com.exadel.model.IEntity;
import com.exadel.model.constants.SpringSecurityRole;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "USER_")
@Inheritance(strategy=InheritanceType.JOINED)
public class User implements IEntity{

    private Long id;
    private String firstName;
    private String secondName;
    private String surname;
    private String login;
    private String password;
    public User() {

    }
    @Column(name = "first_name")
	public String getFirstName() {
	    return firstName;
	}
    @Transient
    @JsonIgnore
    public String getFullName(){
    	return getFirstName()+" "+getSurname()+" "+getSecondName();
    }
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	public Long getId() {
	    return id;
	}

	@Column(name = "login")
	@NaturalId
	public String getLogin() {
	    return login;
	}

	@JsonIgnore
	@Column(name="pass")
	public String getPassword() {
	    return password;
	}

	@Transient
    @JsonIgnore
    public String getRole(){
    	return SpringSecurityRole.USER;
    }

	@Column(name = "second_name")
	public String getSecondName() {
	    return secondName;
	}


	@Column(name = "surname")
	public String getSurname() {
	    return surname;
	}

	public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setId(Long id){
        this.id= id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setSurname(String surname) {
        this.surname= surname;
    }

}
