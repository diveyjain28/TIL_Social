package com.til.socialapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.til.socialapp.adaptor.PostAdaptor;
import com.til.socialapp.model.Employee;
import com.til.socialapp.model.Like;
import com.til.socialapp.model.Post;
import com.til.socialapp.model.PostResponse;
import com.til.socialapp.repository.EmployeeRepository;
import com.til.socialapp.repository.LikeRepository;
import com.til.socialapp.repository.PostRepository;

@Service
public class LikeService {
	@Autowired
	private LikeRepository like;
	@Autowired
	private PostRepository pr;
	@Autowired
	private EmployeeRepository emp;
	@Autowired
	private ValidationService vs;

	public PostResponse likePostService(Like l) {
		vs.checkEmpIdExists(l.getEmpId());
		vs.checkPostId(l.getPostId());
		Post post = pr.findByPostId(l.getPostId());
		int empid = pr.findByPostId(l.getPostId()).getEmpId();
		
		Employee employee = emp.findByEmpId(empid);
		PostAdaptor postadaptor = new PostAdaptor();
		int flag = 0;
		List<Like> temp1 = like.findByEmpIdAndPostId(l.getEmpId(), l.getPostId());
		if(post.getLikesCount()<0)
			post.setLikesCount(0);
		if (!temp1.isEmpty()) {
			
			
			post.setLikesCount(post.getLikesCount() - 1);
			if(post.getLikesCount()<0)
				post.setLikesCount(0);
			like.delete(temp1.get(0));
			pr.save(post);
			
		}
		else
		{
			post.setLikesCount(post.getLikesCount() + 1);
			pr.save(post);
			flag = -1;
			like.save(l);
		}

		PostResponse ret = postadaptor.convert(post, employee);
		if (flag == -1) {
			ret.setHasLiked(true);
		}
		return ret;
	}
}