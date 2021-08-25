package com.til.socialapp.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.til.socialapp.model.Common;

import com.til.socialapp.repository.CommonRepository;
import com.til.socialapp.repository.EmployeeRepository;
import com.til.socialapp.repository.TagPojoRepository;
import com.til.socialapp.repository.TeamsRepository;

@Service
public class CommonService {
	//@Autowired
	//private CommonRepository cr;
	@Autowired
	private TagPojoRepository tar;
	@Autowired
	private TeamsRepository  ter;
	

	
	
	public Common fetchCommonService()
	{
		Common ret=new Common();
		
		List<String> temp=new ArrayList<String>();
		for(int i=0;i<tar.findAll().size();i++)
		{
			temp.add(tar.findAll().get(i).getTags());
		}
		ret.setTags(temp);
		ret.setTeams(ter.findAll());
		
		return ret;
		
	}

}