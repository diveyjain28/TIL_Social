package com.til.socialapp.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="tag")
public class TagPojo {
	
	private String tag;
	public TagPojo() {
		
	}
	public TagPojo(String tag) {
		super();
		this.tag = tag;
	}

	public String getTags() {
		return tag;
	}

	public void setTags(String tag) {
		this.tag = tag;
	}
	
	

}