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
	
	public void likePostService(Like l)
	{
		List<Post> temp1=pr.findAll();
		List<Like> temp2=like.findAll();
		Post p=null;
		int flag=0;
		for(int i=0;i<temp2.size();i++)
		{
			if(temp2.get(i).getEmpId()==l.getEmpId())
			{
				flag=1;
				break;
			}
		}
		for(int i=0;i<temp1.size();i++)
		{
			if(temp1.get(i).getPostId().toString().equals( l.getPostId().toString() ) )
			{
				if(flag==0)
				{
					p=temp1.get(i);
					p.setLikesCount(p.getLikesCount()+1);
					like.save(l);
				}
				else
				{
					p=temp1.get(i);
					p.setLikesCount(p.getLikesCount()-1);
					like.delete(l);
				}
			}
		}
		if(p==null)
			pr.save(p);
		else
		{
			pr.deleteById(p.getPostId());
			pr.save(p);
		}
	}
}
