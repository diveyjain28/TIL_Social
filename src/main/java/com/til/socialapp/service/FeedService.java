package com.til.socialapp.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
		Sort sort=null;
		if(sorted.equals("recency"))
		{
			sort = Sort.by(Sort.Order.desc("createdAt"));
		}
		else if(sorted.equals("trending"))
		{
			sort = Sort.by(Sort.Order.desc("likesCount"),Sort.Order.desc("createdAt"));
		}
		Pageable pageable = PageRequest.of(page, 5,sort);
		Page<Post> feed = null;
		Employee e = emp.findByEmpId(empId);
		List<PostResponse> ret = new ArrayList<PostResponse>();
		if (tag == null) {
			if (type.equals("feed")) {
					feed = post.findByEmpIdNotAndTagsIn(empId, e.getInterests(), pageable);
			} else if (type.equals("self")) {
					feed = post.findByEmpId(empId, pageable);
			}
		} else {
			String interests[] = { tag };
			feed=post.findByTagsIn(interests, pageable);
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
		return feedret;
	}
}