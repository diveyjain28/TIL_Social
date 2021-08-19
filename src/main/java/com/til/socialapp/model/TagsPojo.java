package com.til.socialapp.model;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="tags")
public class TagsPojo {
	
	private String[] tags;
	public TagsPojo() {
		
	}
	public TagsPojo(String[] tags) {
		super();
		this.tags = tags;
	}

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}
	
	

}