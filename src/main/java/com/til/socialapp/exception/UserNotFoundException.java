package com.til.socialapp.exception;


public class UserNotFoundException extends SocialAppException 
{
	//private int status=404;
	private static final long serialVersionUID = 1L;

	public UserNotFoundException() {
		super();
		setStatus(404);
		// TODO Auto-generated constructor stub
	}



	public UserNotFoundException(String message) {
		super(message);
		setStatus(404);
		// TODO Auto-generated constructor stub
	}

	

}
