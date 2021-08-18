package com.til.socialapp.adaptor;

import org.springframework.beans.BeanUtils;

import com.til.socialapp.model.Comment;
import com.til.socialapp.model.CommentResponse;
import com.til.socialapp.model.Employee;

public class CommentAdaptor {
	public CommentResponse convert(Comment comment, Employee e) {

		CommentResponse ret = new CommentResponse();
		ret.setPostId(comment.getPostId().toString());
		BeanUtils.copyProperties(comment, ret);
		ret.setDesignation(e.getDesignation());
		ret.setName(e.getName());
		ret.setCommentId(comment.getCommentId().toString());
		ret.setEmpImgUrl(e.getImgUrl());
		return ret;
	}
}
