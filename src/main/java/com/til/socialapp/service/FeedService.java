package com.til.socialapp.service;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.til.socialapp.repository.EmployeeRepository;
import com.til.socialapp.repository.LikeRepository;
import com.til.socialapp.repository.PostRepository;

import com.til.socialapp.adaptor.PostAdaptor;
import com.til.socialapp.model.Employee;
import com.til.socialapp.model.FeedResponse;
import com.til.socialapp.model.Like;

import com.til.socialapp.model.Post;
import com.til.socialapp.model.PostResponse;

@Service
public class FeedService {
	@Autowired
	private PostRepository post;
	@Autowired
	private EmployeeRepository emp;
	@Autowired
	private LikeRepository like;


	public FeedResponse getFeed(String sorted, int empId, String type, int page, String tag) {
		Pageable pageable = PageRequest.of(page, 5);
		Page<Post> feed = null;
		Employee e = emp.findByEmpId(empId);
		List<PostResponse> ret = new ArrayList<PostResponse>();
		if (tag == null) {
			if (type.equals("feed")) {
				if (sorted.equals("recency")) {
					feed = post.findByEmpIdNotAndTagsInOrderByCreatedAtDesc(empId, e.getInterests(), pageable);
				} else {
					feed = post.findByEmpIdNotAndTagsInOrderByLikesCountDesc(empId, e.getInterests(), pageable);
				}
			} else if (type.equals("self")) {
				if (sorted.equals("recency")) {
					feed = post.findByEmpIdOrderByCreatedAtDesc(empId, pageable);
				} else {
					feed = post.findByEmpIdOrderByCreatedAtDesc(empId, pageable);
				}
			}
		} else {
			String interests[] = { tag };
			if (sorted.equals("recency")) {
				feed = post.findByTagsInOrderByCreatedAtDesc(interests, pageable);
			} else {
				feed = post.findByTagsInOrderByLikesCountDesc(interests, pageable);
			}
		}
		for (int i = 0; i < feed.getNumberOfElements(); i++) {
			Post p = feed.getContent().get(i);
			Employee employee = emp.findByEmpId(p.getEmpId());
			PostAdaptor postadaptor = new PostAdaptor();
			PostResponse temp = postadaptor.convert(p, employee);
			List<Like> temp1 = like.findByEmpIdAndPostId(empId, p.getPostId().toString());
			if (!temp1.isEmpty()) {
				if (temp.getPostId().equals(temp1.get(0).getPostId())) {
					temp.setHasLiked(true);
				}
			}
			ret.add(temp);
		}
//		int totalPgaes=feed.getTotalPages();
//		System.out.println(totalPgaes);
		//Page<PostResponse> pageret = new PageImpl<>(ret);
		FeedResponse feedret = new FeedResponse();
		feedret.setContent(ret);
		if(feed.getNumber()==0)
		{
			feedret.setFirst(true);
		}
		
		feedret.setTotalPages(feed.getTotalPages());
	    feedret.setTotalElements(feed.getTotalElements());
	    feedret.setSize(feed.getSize());
	    feedret.setNumber(feed.getNumber());
	    if(feed.getNumber()>=feed.getTotalPages()-1)
		{
			feedret.setLast(true);
		}
		if(feed.getNumberOfElements()==0)
		{
			feedret.setEmpty(true);
		}
	    feedret.setNumberOfElements(feed.getNumberOfElements());
	    //feed.get
		//return pageret;
		return feedret;
	}
}