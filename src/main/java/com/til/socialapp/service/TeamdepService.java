package com.til.socialapp.service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;


import com.til.socialapp.mongodbdata.teamdep;
import com.til.socialapp.repository.teamdepRepository;


@Service
public class TeamdepService {
	
	private teamdepRepository tdR;

	public TeamdepService(teamdepRepository tdR) {
		super();
		this.tdR = tdR;
	}
	
	public String addTeamdepService(teamdep td)
	{
		tdR.save(td);
		
		//cout<<td;
		
		System.out.print(td.getDep());
		
		return "YashSinglaadded";
	}
	
	
	

}
