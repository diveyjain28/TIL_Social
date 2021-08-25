package com.til.socialapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.til.socialapp.exception.SocialAppException;
import com.til.socialapp.exception.UserNotFoundException;
import com.til.socialapp.model.Employee;
import com.til.socialapp.model.Post;
import com.til.socialapp.repository.EmployeeRepository;
import com.til.socialapp.repository.PostRepository;

@Service
public class ValidationService {
    @Autowired
	EmployeeRepository emp;
    @Autowired
    PostRepository pr;
    
    public void checkEmpIdExists(int empId)
    {
    	Employee e=emp.findByEmpId(empId);
    	if(e==null)
    	{
    		throw new UserNotFoundException("Employee ID " + empId + " doesn't exist");
    	}
    }
    public void checkEmpId(int empId)
    {
    	if(empId/10000!=1450)
    	{
    		
    		throw new SocialAppException("Employee id is invalid. Employee id should be a 8 digit number starting with 1450.");		
    	}
    }
    
    public void checkPostId(String postId)
    {
    	Post p=pr.findByPostId(postId);
    	if(p==null)
    	{
    		throw new SocialAppException("Post with postId:"+postId+" doesn't exists");
    	}
    }
    public void checkCommentNull(String content)
    {
    	if(content==null)
    	{
    		throw new SocialAppException("You can't post a comment without any data.");
    	}
    }
    
    public void checkPostData(String content, String[] images, String[] videos)
    {
    	if(content==null && images==null && videos==null)
    	{
    		throw new SocialAppException("You can't post a post without any data");
    	}
    }
}
