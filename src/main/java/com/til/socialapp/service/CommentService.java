package com.til.socialapp.service;

import java.util.*;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.til.socialapp.adaptor.CommentAdaptor;
import com.til.socialapp.model.Comment;
import com.til.socialapp.model.CommentResponse;
import com.til.socialapp.model.Employee;
import com.til.socialapp.model.Post;
import com.til.socialapp.repository.CommentRepository;
import com.til.socialapp.repository.EmployeeRepository;
import com.til.socialapp.repository.PostRepository;

@Service
public class CommentService {
	@Autowired
	CommentRepository cr;
	@Autowired
	private PostRepository pr;
	@Autowired
    private EmployeeRepository emp;
	
	public CommentResponse registerServiceComment(Comment comment) {

		Post p = pr.findByPostId(comment.getPostId());
		Employee e=emp.findByEmpId(comment.getEmpId());
		
		cr.save(comment);
		p.setCommentsCount(p.getCommentsCount() + 1);
		pr.save(p);
		CommentAdaptor cAdap=new CommentAdaptor();
		CommentResponse ret=cAdap.convert(comment, e);
		return ret;
	}

	public List<CommentResponse> fetchServiceComment(String postId) {
		List<Comment> comments = cr.findByPostId(postId);
		List<CommentResponse> ret=new ArrayList<CommentResponse>();
		for(int i=0;i<comments.size();i++)
		{
			Employee e=emp.findByEmpId(comments.get(i).getEmpId());
			CommentAdaptor cAdap=new CommentAdaptor();
			CommentResponse cRes=cAdap.convert(comments.get(i), e);
			ret.add(cRes);
			
		}
		return ret;
	}
}
