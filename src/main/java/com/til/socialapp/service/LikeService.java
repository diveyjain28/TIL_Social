package com.til.socialapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.til.socialapp.model.Like;
import com.til.socialapp.model.Post;
import com.til.socialapp.repository.LikeRepository;
import com.til.socialapp.repository.PostRepository;



@Service
public class LikeService 
{
	@Autowired
	private LikeRepository like;
	@Autowired
	private PostRepository pr;
	
	public Like likePostService(Like l)
	{
		List<Like> list= like.findByempId(l.getEmpId());
		Post p=pr.findByPostId(l.getPostId());
		int flag=0;
	    for(int i=0;i<list.size();i++)
	    {
	       if(list.get(i).getPostId().equals(l.getPostId()))
	       {
	    	   flag=1;
	    	   break;
	       }
	    }
	    if(flag==0)
		{
	    	p.setLikesCount(p.getLikesCount()+1);
			pr.save(p);
			l.setLiked(true);
			like.save(l);
			
		}
		else
		{
			p.setLikesCount(p.getLikesCount()-1);
			like.delete(like.findByPostId(l.getPostId()));
			l.setLiked(false);
			pr.save(p);
		}
     return l;
	}
}