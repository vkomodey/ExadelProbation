package com.exadel.model.entity;

import javax.persistence.*;

import com.exadel.model.IEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "USER_")
@Inheritance(strategy=InheritanceType.JOINED)
public class User implements IEntity {

    private long id;
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

    public String getRole(){
        return "ROLE_ADMIN";
    }

    public void setRole(String role){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (!firstName.equals(user.firstName)) return false;
        if (!login.equals(user.login)) return false;
        if (!password.equals(user.password)) return false;
        if (!secondName.equals(user.secondName)) return false;
        if (!surname.equals(user.surname)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + firstName.hashCode();
        result = 31 * result + secondName.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + login.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }
}
