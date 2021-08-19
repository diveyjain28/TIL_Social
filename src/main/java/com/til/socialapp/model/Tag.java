package com.til.socialapp.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Document(collection = "tag")
@Component
public class Tag {

	@Id
	private int empId;
	private String[] tags;   //a list of tags that employee chosen while sign in
	public Tag() {
		
	}
	public Tag(int empId, String[] tags) {
		super();
		this.empId = empId;
		this.tags = tags;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

}
