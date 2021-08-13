package com.til.socialapp.exception;

public class SocialAppException extends RuntimeException {
	private int status = 500;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	private static final long serialVersionUID = 1L;

	public SocialAppException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SocialAppException(String message) {
		super(message);

		// TODO Auto-generated constructor stub
	}

	public SocialAppException(String message, int status) {
		super(message);
		this.status = status;
		// TODO Auto-generated constructor stub
	}
}
