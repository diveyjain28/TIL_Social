package com.til.socialapp.model;

import java.time.LocalDateTime;

public class PostResponse {

	private String postId;
	private int empId;
	private String name;
	private String designation;
	private int likesCount;
	private int commentsCount;
	private boolean hasLiked;

	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private String content;
	private String empImgUrl;
	private String[] tags;
	private String[] images;
	private String[] videos;

	// constructors
	public PostResponse() {
		super();
	}

	public PostResponse(String postId, int empId, String name, String designation, int likesCount, int commentsCount,
			boolean hasLiked, LocalDateTime createdAt, LocalDateTime updatedAt, String content, String empImgUrl,
			String[] tags, String[] images, String[] videos) {
		super();
		this.postId = postId;
		this.empId = empId;
		this.name = name;
		this.designation = designation;
		this.likesCount = likesCount;
		this.commentsCount = commentsCount;
		this.hasLiked = hasLiked;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.content = content;
		this.empImgUrl = empImgUrl;
		this.tags = tags;
		this.images = images;
		this.videos = videos;
	}

	// Getters and setters
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getLikesCount() {
		return likesCount;
	}

	public void setLikesCount(int likesCount) {
		this.likesCount = likesCount;
	}

	public int getCommentsCount() {
		return commentsCount;
	}

	public void setCommentsCount(int commentsCount) {
		this.commentsCount = commentsCount;
	}

	public boolean isHasLiked() {
		return hasLiked;
	}

	public void setHasLiked(boolean hasLiked) {
		this.hasLiked = hasLiked;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getEmpImgUrl() {
		return empImgUrl;
	}

	public void setEmpImgUrl(String empImgUrl) {
		this.empImgUrl = empImgUrl;
	}

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

	public String[] getImages() {
		return images;
	}

	public void setImages(String[] images) {
		this.images = images;
	}

	public String[] getVideos() {
		return videos;
	}

	public void setVideos(String[] videos) {
		this.videos = videos;
	}
}
