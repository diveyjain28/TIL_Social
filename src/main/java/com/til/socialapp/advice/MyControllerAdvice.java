package com.til.socialapp.advice;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.til.socialapp.exception.SocialAppException;

@ControllerAdvice
public class MyControllerAdvice extends ResponseEntityExceptionHandler
{
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleEmptyInput(Exception obj, WebRequest webRequest) 
	{
		ExceptionResponse response = new ExceptionResponse();
		int s=500;
		if(obj instanceof SocialAppException)
		{
			s=((SocialAppException)obj).getStatus();
			System.out.println(s);
			if(((SocialAppException)obj).getStatus()!=500)
			{
				s=((SocialAppException)obj).getStatus();
			}
		}
		HttpStatus status=HttpStatus.valueOf(s);	
		response.setTimestamp(java.time.LocalDateTime.now());
		response.setError(obj.getClass().getSimpleName());
		response.setMessage(obj.getMessage());
		response.setStatus(String.valueOf(s));
		ResponseEntity<Object> entity = new ResponseEntity<>(response,status);
		return entity;
	}
}
