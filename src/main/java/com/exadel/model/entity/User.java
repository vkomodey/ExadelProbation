package com.exadel.model.entity;

import java.io.Serializable;

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
public class User implements IEntity,Serializable{

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}

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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
