package com.til.socialapp.model;

import java.util.List;

public class FeedResponse {
	private List<PostResponse> content;
    private int totalPages;
    private boolean last;
    private long totalElements;
    private int size;
    private int number;
    private boolean first;
    private int numberOfElements;
    private boolean empty;
	

	

	public FeedResponse() {

	}

	public FeedResponse(List<PostResponse> content, int totalPages, boolean last, long totalElements, int size,
			int number, boolean first, int numberOfElements, boolean empty) {
		super();
		this.content = content;
		this.totalPages = totalPages;
		this.last = last;
		this.totalElements = totalElements;
		this.size = size;
		this.number = number;
		this.first = first;
		this.numberOfElements = numberOfElements;
		this.empty = empty;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public List<PostResponse> getContent() {
		return content;
	}

	public void setContent(List<PostResponse> content) {
		this.content = content;
	}

	public boolean isLast() {
		return last;
	}

	public void setLast(boolean last) {
		this.last = last;
	}

	public long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public boolean isFirst() {
		return first;
	}

	public void setFirst(boolean first) {
		this.first = first;
	}

	public int getNumberOfElements() {
		return numberOfElements;
	}

	public void setNumberOfElements(int numberOfElements) {
		this.numberOfElements = numberOfElements;
	}

	public boolean isEmpty() {
		return empty;
	}

	public void setEmpty(boolean empty) {
		this.empty = empty;
	}
	

}
