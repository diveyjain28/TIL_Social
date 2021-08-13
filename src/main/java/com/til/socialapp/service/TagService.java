package com.til.socialapp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.til.socialapp.model.Tag;
import com.til.socialapp.repository.Tagrepository;




@Service
public class TagService {
	
	
	private Tagrepository tag;
	
	
	public TagService(Tagrepository tag) {
		super();
		this.tag = tag;
		
	}
	
	
	
	public String addTagonSignupService(Tag t)
	{
		tag.save(t);
		
		return "YashSingla";
	}
	
	
//	public String TagUpdateService(Tag t, int empId)
//	{
//        List<Tag> tt=tag.findAll();
//		
//		String[] baba=tt.get(i).getTags();
//		
////        List<Tag> tt=tag.findAll();
////		
////		for(int i=0;i<tt.size();i++)
////		{
////			if(tt.get(i).getEmpId()==empId)
////			{
////				tt.get(i).setTags()t.getTags();
////			}
////		}
//		
//		
//		
//		
//	}
	
	
	
	
	//We want to return employee with taglist 
	public Tag fetchTagservicebyemployeeId(int empId)
	{
		Tag ret=null;
		List<Tag> tt=tag.findAll();
		
		for(int i=0;i<tt.size();i++)
		{
			if(tt.get(i).getEmpId()==empId)
			{
				ret=tt.get(i);
			}
		}
		
		return ret;
	}
	
	
	//We want to return on taglist of particular empId
	
	public String[] fetchTaglistservicebyemployeeId(int empId)
	{
		Tag ret=null;
		List<Tag> tt=tag.findAll();
		
		for(int i=0;i<tt.size();i++)
		{
			if(tt.get(i).getEmpId()==empId)
			{
				ret=tt.get(i);
			}
		}
		
		String[] arr=ret.getTags();
		return arr;
	}
	
	
	//we want to delete particular tag in the tag list and then return updated tag list
	
	public String[] fetchTagdeleteservicebyemployeeId(int empId, String deltag)
	{
		Tag ret=null;
        List<Tag> tt=tag.findAll();
		
		for(int i=0;i<tt.size();i++)
		{
			if(tt.get(i).getEmpId()==empId)
			{
				ret=tt.get(i);
			}
		}
		
		List<String> list = new ArrayList<String>(Arrays.asList(ret.getTags()));
		list.remove(deltag);
		String[] tag_array = list.toArray(new String[0]);
		
		return tag_array;
		
	}
	
	
	//we want to add particular tag to list of employeeId
	
	public String[] fetchTagaddservicebyemployeeId(int empId, String addtag)
	{
		Tag ret=null;
        List<Tag> tt=tag.findAll();
		
		for(int i=0;i<tt.size();i++)
		{
			if(tt.get(i).getEmpId()==empId)
			{
				ret=tt.get(i);
			}
		}
		
		List<String> list = new ArrayList<String>(Arrays.asList(ret.getTags()));
		list.add(addtag);
		String[] tag_array = list.toArray(new String[0]);
		
		return tag_array;
		
	}
	
	
	
	
	
//	public void tagService(Tag T)
//	{
//		List<Tag> temp2=tag.findAll();
//		
//		//Post p=null;
//		int flag=0;
//		
//		for(int i=0;i<temp2.size();i++)
//		{
//			if(temp2.get(i)==T)
//			{
//				flag=1;   //we already have the tag no need to do anything
//				break;
//			}
//		}
//		
//		if(flag==0)
//		{
//			tag.save(T);   //we save the tag if not there 
//		}
//	}
	
	
	
	
		
//		public List<Tag> fetchServiceTag(ObjectId postId)
//		{
//			List<Tag> t=tag.findAll();
//		    List<Tag> tagsreturn = new ArrayList<Tag>() ;
//		    
//		    for(int i=0;i<t.size();i++)
//			{
//				 aif(t.get(i).getPostId().equals(postId))
//				{
//					 tagsreturn.add(t.get(i));
//				}
//			}
//		    
//		    return tagsreturn;
//		}
		
		
	
	

}
