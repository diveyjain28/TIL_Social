package com.til.socialapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import com.til.socialapp.mongodbdata.teamdep;
import com.til.socialapp.repository.teamdepRepository;
import com.til.socialapp.service.TeamdepService;

import java.util.List;
import java.util.Map;

@RestController
public class TeamDepController {
	
	@Autowired
	private TeamdepService tDServ;
	
//	 @GetMapping("/teamdepss")
//	   String findteamdep()
//	   {
//		   return tDServ.fetchteam("TOI").get;
//	   }
	    
	    @PostMapping("/teammdep/save")
	    String addTeamDepService(@RequestBody teamdep td)
	    {
	    	tDServ.addTeamdepService(td);
	    	return "Yash got Tags17";
	    }
	
	
//	@PostMapping("/teammdep/save")
//    String addTeamDepService(@RequestBody String a)
//    {
//    	return "Yash got Tags20";
//    }

}
