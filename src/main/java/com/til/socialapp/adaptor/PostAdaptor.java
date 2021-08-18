package com.til.socialapp.adaptor;

import org.springframework.beans.BeanUtils;
import com.til.socialapp.model.Employee;
import com.til.socialapp.model.Post;
import com.til.socialapp.model.PostResponse;

public class PostAdaptor {

	public PostResponse convert(Post p, Employee e) {

		PostResponse ret = new PostResponse();
		ret.setPostId(p.getPostId().toString());
		BeanUtils.copyProperties(p, ret);
		ret.setDesignation(e.getDesignation());
		ret.setName(e.getName());
		ret.setHasLiked(false);
		ret.setEmpImgUrl(e.getImgUrl());
		return ret;
	}
}
