package com.til.socialapp.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "like")
public class Like 
{
	@Id
	private String postId;
	private boolean liked;
	private int empId;
	public Like() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Like(boolean liked, String postId, int empId) {
		super();
		this.liked = liked;
		this.postId = postId;
		this.empId = empId;
	}
	public boolean isLiked() {
		return liked;
	}
	public void setLiked(boolean liked) {
		this.liked = liked;
	}
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
}
