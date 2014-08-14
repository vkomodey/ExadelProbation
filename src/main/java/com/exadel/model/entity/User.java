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
    private String middleName;
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
    	return getFirstName()+" "+getSurname()+" "+ getMiddleName();
    }
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	public Long getId() {
	    return id;
	}

    @NaturalId
    @Column(name = "login")
    public String getName() {
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
	public String getMiddleName() {
	    return middleName;
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

    public void setName(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setSurname(String surname) {
        this.surname= surname;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
