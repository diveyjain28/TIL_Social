package com.til.socialapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import com.til.socialapp.model.Tag;
import com.til.socialapp.repository.Tagrepository;
import com.til.socialapp.service.TagService;

import java.util.List;
import java.util.Map;

@RestController
public class TagController {
	
	 @Autowired
	 //private Tagrepository tagrepository;
	 private TagService tagsserv;

	    // Find
//	    @GetMapping("/tags")
//	    List<Tag> findAll() {
//	        return tagrepository.findAll();
//	    }
//	    
//	    @PostMapping("/tag/save")
//	    String savetags(@RequestBody Tag t)
//	    {
//	    	tagrepository.save(t);
//	    	return "Yash got Tags15";
//	    }

	    
	    
//	    @GetMapping("/tags")
//	    List<Tag> findAll() {
//	        return tagsserv.findAll();
//	    }
	 
//	   @GetMapping("/profile/fetchtags")
//	   String findTagsss()
//	   {
//		   return tagsserv.fetchTaglistservicebyemployeeId(152)[0];
//	   }
//	   
	   @GetMapping("/profile/fetchtags/{empId}")
	   String findTagsss(@PathVariable("empId") int empId)
	   {
		   return tagsserv.fetchTaglistservicebyemployeeId(empId)[0];
	   }
	 
//	   @GetMapping("/tagsss")
//	   String findTagsss()
//	   {
//		   return tagsserv.fetchTaglistservicebyemployeeId(152)[0];
//	   }
	    
	    @PostMapping("/tag/save")
	    String addTagService(@RequestBody Tag t)
	    {
	    	tagsserv.addTagonSignupService(t);
	    	return "TagsAdded";
	    }
}
