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

	public PostResponse likePostService(Like l) {
		List<Like> list = like.findByempId(l.getEmpId());
		Post post = pr.findByPostId(l.getPostId());
		int empid = pr.findByPostId(l.getPostId()).getEmpId();
		Employee employee = emp.findByEmpId(empid);
		PostAdaptor postadaptor = new PostAdaptor();
		PostResponse ret = postadaptor.convert(post, employee);
		int flag = 0;

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getPostId().equals(l.getPostId())) {
				flag = 1;
				break;
			}
		}
		if (flag == 0) {
			post.setLikesCount(post.getLikesCount() + 1);
			pr.save(post);
			flag = -1;
			like.save(l);
		} else {
			post.setLikesCount(post.getLikesCount() - 1);
			like.delete(like.findByPostId(l.getPostId()));
			pr.save(post);
		}
		ret = postadaptor.convert(post, employee);
		if (flag == -1) {
			ret.setHasLiked(true);
		}
		return ret;
	}
}