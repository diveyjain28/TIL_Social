package com.til.socialapp.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.til.socialapp.model.Common;

import com.til.socialapp.repository.CommonRepository;
import com.til.socialapp.repository.EmployeeRepository;

@Service
public class CommonService {
	@Autowired
	private CommonRepository cr;
    
	
	public CommonService(CommonRepository cr) {
		super();
		this.cr = cr;
	}
	
	public Common fetchCommonService()
	{
		
		return cr.findAll().get(1);
	}

}
