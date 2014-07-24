package com.exadel.model.entity;

import javax.persistence.*;

import com.exadel.model.IEntity;
import com.exadel.model.constants.SpringSecurityRole;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "USER_")
@Inheritance(strategy=InheritanceType.JOINED)
public class User implements IEntity{

    private long id;
    private String firstName;
    private String secondName;
    private String surname;
    private String login;
    private String password;

    public User() {

    }
    @Transient
    @JsonIgnore
    public String getRole(){
    	return SpringSecurityRole.USER;
    }
    @Column(name = "first_name")
	public String getFirstName() {
	    return firstName;
	}

	@Column(name = "second_name")
	public String getSecondName() {
	    return secondName;
	}

	@Column(name = "surname")
	public String getSurname() {
	    return surname;
	}

	@Column(name = "login")
	public String getLogin() {
	    return login;
	}

	@JsonIgnore
	@Column(name="pass")
	public String getPassword() {
	    return password;
	}


	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
	    return id;
	}

	public void setId(long id){
        this.id=id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setSurname(String surname) {
        this.surname= surname;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
