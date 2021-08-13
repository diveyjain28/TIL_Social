package com.til.socialapp.mongodbdata;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public class departments {
	private String name;
	private String[] designations;
	public departments(String name, String[] designations) {
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
