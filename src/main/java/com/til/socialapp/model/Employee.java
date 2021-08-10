package com.til.socialapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="employee")
public class Employee {
	 @Id
	 private int empId;
	 private String name;
	 private String dept;
	 private String bio;
	 private String team;
	 private String designation;
	 private String[] interests;
	 
	 
	
	 //Constructor
	public Employee(String name, int empId, String dept, String bio, String team, String designation,
			String[] interests) {
		super();
		this.name = name;
		this.empId = empId;
		this.dept = dept;
		this.bio = bio;
		this.team = team;
		this.designation = designation;
		this.interests = interests;
	}
	//Getters and Setters 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String[] getInterests() {
		return interests;
	}
	public void setInterests(String[] interests) {
		this.interests = interests;
	}
	 
}
