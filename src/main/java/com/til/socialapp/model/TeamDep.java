package com.til.socialapp.model;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document(collection="common")
public class TeamDep {
	
	//@BsonProperty(value = "team")
	private String team;
	
	@BsonProperty(value="departments")
	private Departments[] departments;
	
	
	public TeamDep(String team, Departments[] departments) {
		super();
		this.team = team;
		this.departments = departments;
	}


	public String getTeam() {
		return team;
	}


	public void setTeam(String team) {
		this.team = team;
	}


	public Departments[] getDep() {
		return departments;
	}


	public void setDep(Departments[] departments) {
		this.departments = departments;
	}
	
	
	
	
	

}
