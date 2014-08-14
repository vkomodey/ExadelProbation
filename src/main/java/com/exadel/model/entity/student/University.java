package com.exadel.model.entity.student;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NaturalId;

import com.exadel.model.NamedEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class University implements NamedEntity{

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		University other = (University) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	private Long id;
	private String name;
	private Set<Faculty> faculties;
	public University(){
		
	}
	@OneToMany(cascade=CascadeType.ALL,mappedBy="university")
	@JsonIgnore
	public Set<Faculty> getFaculties() {
		return faculties;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	@NaturalId
	public String getName() {
		return name;
	}
	public void setFaculties(Set<Faculty> faculties) {
		this.faculties = faculties;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return getName();
	}
}
