package com.til.socialapp.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Document(collection = "common")
@Component
public class Common {
	private String[] tags;
	private Teams[] teams;

//constructors
	public Common(String[] tags, Teams[] teams) {
		super();
		this.tags = tags;
		this.teams = teams;
	}

	public Common() {
		super();
	}

//Getters and setters
	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

	public Teams[] getTeams() {
		return teams;
	}

	public void setTeams(Teams[] teams) {
		this.teams = teams;
	}

}
