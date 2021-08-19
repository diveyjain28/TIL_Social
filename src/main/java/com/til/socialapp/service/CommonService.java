package com.til.socialapp.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.til.socialapp.model.Common;

import com.til.socialapp.repository.CommonRepository;
import com.til.socialapp.repository.EmployeeRepository;
import com.til.socialapp.repository.TagsPojoRepository;
import com.til.socialapp.repository.TeamsRepository;

@Service
public class CommonService {
	//@Autowired
	//private CommonRepository cr;
	@Autowired
	private TagsPojoRepository tar;
	@Autowired
	private TeamsRepository  ter;
    
	
//	public CommonService(CommonRepository cr) {
//		super();
//		this.cr = cr;
//	}
	
	
	
	public Common fetchCommonService()
	{
		Common ret=new Common();
		ret.setTags(tar.findAll().get(0).getTags());
		
		ret.setTeams(ter.findAll());
		
		return ret;
		
		
		//return cr.findAll().get(1);
	}

}