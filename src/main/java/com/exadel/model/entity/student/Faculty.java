package com.exadel.model.entity.student;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NaturalId;

import com.exadel.model.NamedEntity;
import com.fasterxml.jackson.annotation.JsonValue;
@Entity
public class Faculty implements NamedEntity{
	private Long id;
	private String name;
	private University university;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	@NaturalId
	public String getName() {
		return name;
	}
	@ManyToOne
	@NaturalId
	public University getUniversity() {
		return university;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setUniversity(University university) {
		this.university = university;
	}
	public Faculty(){
		
	}
	@Override
	public String toString() {
		return getName();
	}
	@JsonValue
	public Map<String,Object> toJSON(){
		 Map<String,Object> map=new LinkedHashMap<String, Object>(3);
		 map.put("name", getName());
		 map.put("id", getId());
		 map.put("university", getUniversity().getName());
		 return map;
	}
}
