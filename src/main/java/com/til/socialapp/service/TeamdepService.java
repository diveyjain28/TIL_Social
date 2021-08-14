package com.til.socialapp.service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.til.socialapp.model.TeamDep;
import com.til.socialapp.repository.TeamDepRepository;

@Service
public class TeamdepService {
	
	private TeamDepRepository tdR;

	public TeamdepService(TeamDepRepository tdR) {
		super();
		this.tdR = tdR;
	}
	
	public TeamDep fetchTeamdepService()
	{
		
		return tdR.findAll().get(0);
	}

}
