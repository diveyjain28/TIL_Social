package com.til.socialapp.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="common")
public class Common {
private String[] tags;
private List<Teams> teams;


public Common() {
	super();
}
public Common(String[] tags, List<Teams> teams) {
	super();
	this.tags = tags;
	this.teams = teams;
}
public String[] getTags() {
	return tags;
}
public void setTags(String[] tags) {
	this.tags = tags;
}
public List<Teams> getTeams() {
	return teams;
}
public void setTeams(List<Teams> teams) {
	this.teams = teams;
}
}