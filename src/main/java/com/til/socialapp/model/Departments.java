package com.til.socialapp.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="departments")
public class Departments {

	private String name;
	private String[] designations;
	public Departments() {
		
	}
	public Departments(String name, String[] designations) {
		super();
		this.name = name;
		this.designations = designations;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getDesignations() {
		return designations;
	}
	public void setDesignations(String[] designations) {
		this.designations = designations;
	}
	
	

}
