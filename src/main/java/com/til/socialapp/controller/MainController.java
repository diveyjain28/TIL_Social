package com.til.socialapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.til.socialapp.model.Comment;
import com.til.socialapp.model.CommentResponse;
import com.til.socialapp.model.Common;
import com.til.socialapp.model.Employee;
import com.til.socialapp.model.FeedResponse;
import com.til.socialapp.model.Like;
import com.til.socialapp.model.Post;
import com.til.socialapp.model.PostResponse;
import com.til.socialapp.model.Tag;
import com.til.socialapp.service.CommentService;
import com.til.socialapp.service.CommonService;
import com.til.socialapp.service.EmployeeService;
import com.til.socialapp.service.FeedService;
import com.til.socialapp.service.LikeService;
import com.til.socialapp.service.PostService;
import com.til.socialapp.service.TagService;

@CrossOrigin
@RestController
@RequestMapping("/tilsocialapp")
public class MainController {
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
	@Autowired
	private CommonService cserv;
	@Autowired
	private TagService tagsserv;

	// APIs for profile save and fetch
	@PostMapping("/profile/save")
	public Employee register(@RequestBody Employee emp) {
		Employee ret = empserv.registerService(emp);
		return ret;
	}

	@GetMapping("/profile/fetch/{empId}")
	public Employee fetchEmployeeById(@PathVariable("empId") int empId) {
		Employee ret = empserv.fetchServiceEmployeeById(empId);
		return ret;
	}

	// APIs for comment save and fetch
	@PostMapping("/comment/save")
	public CommentResponse registerComment(@RequestBody Comment comment) {
		// Comment ret=comserv.registerServiceComment(comment);
		return comserv.registerServiceComment(comment);
	}

	@GetMapping("/comment/fetch/{postId}")
	public List<CommentResponse> fetchComment(@PathVariable("postId") String postId) {
		// List<Comment> ret=comserv.fetchServiceComment(postId);
		return comserv.fetchServiceComment(postId);
	}

	// API for Post Save
	@PostMapping("/post/save")
	public PostResponse savePost(@RequestBody Post post) {
		// Post ret=postserv.savePostService(post);
		return postserv.savePostService(post);
	}

	// API for like
	@PostMapping("/like/save")
	public PostResponse likePost(@RequestBody Like like) {
		return likeserv.likePostService(like);
	}

	// API for feed
	@GetMapping("/post/fetch")
	@ResponseBody
	public FeedResponse feedPost(@RequestParam("page") int page, @RequestParam("sortBy") String sorted,
			@RequestParam("empId") int empid, @RequestParam("type") String type) {
		return feedserv.getFeed(sorted, empid, type, page);
	}

	@PostMapping("/profile/tag/save")
	public Tag updateTag(@RequestBody Tag t1) {
		Tag ret = tagsserv.updateserviceTag(t1);
		return ret;
	}

	@GetMapping("/common/fetch")
	public Common addTeamDepService() {
		Common c = cserv.fetchCommonService();

		return c;

	}
}
