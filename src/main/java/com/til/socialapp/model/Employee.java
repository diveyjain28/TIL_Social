package com.til.socialapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Document(collection = "employee")
@Component
public class Employee {
	@Id
	private int empId;
	private String name;
	private String department;
	private String bio;
	private String team;
	private String designation;
	private String[] interests;
	private String imgUrl;

	// Constructor
	public Employee() {
	}

	public Employee(String name, int empId, String department, String bio, String team, String designation,
			String[] interests, String imgUrl) {
		super();
		this.name = name;
		this.empId = empId;
		this.department = department;
		this.bio = bio;
		this.team = team;
		this.designation = designation;
		this.interests = interests;
		this.imgUrl = imgUrl;
	}

	// Getters and Setters
	public String getName() {
		return name;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
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
