package com.til.socialapp.model;

import java.util.List;

public class FeedResponse {
	private List<PostResponse> content;

	public FeedResponse(List<PostResponse> content) {
		super();
		this.content = content;
	}

	public FeedResponse() {

	}

	public List<PostResponse> getContent() {
		return content;
	}

	public void setContent(List<PostResponse> content) {
		this.content = content;
	}

}
