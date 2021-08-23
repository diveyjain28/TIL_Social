package com.til.socialapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.til.socialapp.model.Common;
import com.til.socialapp.service.CommonService;

@CrossOrigin
@RestController
@RequestMapping("/common")
public class CommonController {
	
	@Autowired
	private CommonService cserv;
	@GetMapping("/fetch")
	public Common addTeamDepService()
	{
		Common c=cserv.fetchCommonService();	
		return c;
	}
}
