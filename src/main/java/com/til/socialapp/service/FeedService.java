package com.til.socialapp.service;



import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.til.socialapp.repository.PostRepository;
import com.til.socialapp.model.Post;

@Service
public class FeedService {
	@Autowired
	private PostRepository post;


	public Page<Post> getFeed(String sorted, int empId, String type,int page) {
		Pageable pageable=PageRequest.of(page, 5);
		Page<Post> feed = null;
		if(type.equals("feed"))
		{
			if(sorted.equals("recency"))
			{
				feed= post.findByEmpIdNotOrderByCreatedAtDesc(empId,pageable);
			}
			else
			{
				feed= post.findByEmpIdNotOrderByLikesCountDesc(empId,pageable);
			}
		}
		else
		{
			if(sorted.equals("recency"))
			{
				feed= post.findByEmpIdOrderByCreatedAtDesc(empId,pageable);
			}
			else
			{
				feed= post.findByEmpIdOrderByLikesCountDesc(empId,pageable);
			}
		}
//		if (type.equals("feed")) {
//			feed = getOtherPost(empid);
//		} else {
//			feed = getMyPost(empid);
//		}
//		if (sorted.equals("recency")) {
//			feed = sortByRecency(feed);
//		} else {
//			feed = sortByTrending(feed);
//		}
		return feed;
	}

//	public List<Post> sortByTrending(List<Post> feed) {
//		Comparator<Post> com = new Comparator<Post>() {
//			public int compare(Post p1, Post p2) {
//				if (p1.getLikesCount() > p2.getLikesCount())
//					return -1;
//				else
//					return 1;
//			}
//		};
//		Collections.sort(feed, com);
//		return feed;
//	}
//
//	public List<Post> sortByRecency(List<Post> feed) {
//		Comparator<Post> com = new Comparator<Post>() {
//			public int compare(Post p1, Post p2) {				
//				LocalDateTime d1 = p1.getCreatedAt();
//				LocalDateTime d2 = p2.getCreatedAt();
//					if (d1.isBefore(d2))
//						return 1;
//					else
//						return -1;
//			}
//		};
//		Collections.sort(feed, com);
//		return feed;
//	}

//	public List<Post> getOtherPost(int empid) {
//		List<Post> feed = post.findAll();
//		List<Post> finalfeed = new ArrayList<Post>();
//		for (int i = 0; i < feed.size(); i++) {
//			if (feed.get(i).getEmpId() != empid)
//				finalfeed.add(feed.get(i));
//		}
//		return finalfeed;
//	}
//
//	public List<Post> getMyPost(int empid) {
//		List<Post> feed = post.findAll();
//		//Add limit
//		//Custom query
//		List<Post> finalfeed = new ArrayList<Post>();
//		for (int i = 0; i < feed.size(); i++) {
//			if (feed.get(i).getEmpId() == empid)
//				finalfeed.add(feed.get(i));
//		}
//		return finalfeed;
//	}
}
