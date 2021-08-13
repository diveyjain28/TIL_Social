package com.til.socialapp.mongodbdata;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document(collection="Data_DB")
public class teamdep {
	
	@BsonProperty(value = "team")
	private String team;
	
	@BsonProperty(value="dep")
	private ArrayList<departments> dep;
	
	
	public teamdep(String team, ArrayList<departments> dep) {
		super();
		this.team = team;
		this.dep = dep;
	}


	public String getTeam() {
		return team;
	}


	public void setTeam(String team) {
		this.team = team;
	}


	public ArrayList<departments> getDep() {
		return dep;
	}


	public void setDep(ArrayList<departments> dep) {
		this.dep = dep;
	}
	
	
	
	
	

}
