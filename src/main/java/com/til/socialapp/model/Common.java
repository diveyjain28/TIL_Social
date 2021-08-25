package com.til.socialapp.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Document(collection = "common")
@Component
public class Common {
private List<String> tags;
private List<Teams> teams;


public Common() {
	super();
}
public Common(List<String> tags, List<Teams> teams) {
	super();
	this.tags = tags;
	this.teams = teams;
}
public List<String> getTags() {
	return tags;
}
public void setTags(List<String> tags) {
	this.tags = tags;
}
public List<Teams> getTeams() {
	return teams;
}
public void setTeams(List<Teams> teams) {
	this.teams = teams;
}
}
