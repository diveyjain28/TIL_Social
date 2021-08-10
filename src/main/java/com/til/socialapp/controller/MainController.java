package com.til.socialapp.controller;

import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.til.socialapp.model.Comment;
import com.til.socialapp.model.Employee;
import com.til.socialapp.model.Like;
import com.til.socialapp.model.Post;
import com.til.socialapp.service.CommentService;
import com.til.socialapp.service.EmployeeService;
import com.til.socialapp.service.FeedService;
import com.til.socialapp.service.LikeService;
import com.til.socialapp.service.PostService;

@RestController
@RequestMapping("/tilsocialapp")
public class MainController 
{
	@Autowired
	private EmployeeService empserv;
	@Autowired
	private PostService postserv;
	@Autowired
	private LikeService likeserv;
	@Autowired
	private CommentService comserv;
	@Autowired
	private FeedService feedserv;
	//APIs for profile save and fetch
	@PostMapping("/profile/save")
	public String register(@RequestBody Employee emp)
	{
		empserv.registerService(emp);
		return "User registered successfully";
	}
	@GetMapping("/profile/fetch/{empId}")
	public Employee fetchEmployeeById(@PathVariable("empId") int empId)
	{
		Employee ret=empserv.fetchServiceEmployeeById(empId);
		return ret;
	}
	
	//APIs for comment save and fetch
	@PostMapping("/comment/save")
	public String registerComment(@RequestBody Comment comment)
	{
		comserv.registerServiceComment(comment);
		return "User registered successfully";
	}
	@GetMapping("/comment/fetch/{postId}")
	public List<Comment> fetchComment(@PathVariable("postId") String postId)
	{
		List<Comment> ret=comserv.fetchServiceComment(postId);
		return ret;
	}
	
	//API for Post Save
	@PostMapping("/post/save")
	public String savePost(@RequestBody Post post)
	{
		postserv.savePostService(post);
		return "Post saved successfully";
	}
	
	//API for like
	@PostMapping("/like/save")
	public String likePost(@RequestBody Like like)
	{
		likeserv.likePostService(like);
		return "Post liked successfully";
	}
	
	@GetMapping("/post/fetch")
	@ResponseBody
	public Page<Post> feedPost(@RequestParam("page") int page,@RequestParam("sortBy") String sorted,@RequestParam("empId") int empid,
			@RequestParam("type") String type)
	{
		Page<Post> feed= feedserv.getFeed(sorted, empid, type,page);
		return feed;
	}
	
}
