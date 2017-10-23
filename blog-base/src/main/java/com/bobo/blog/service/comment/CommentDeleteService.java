package com.bobo.blog.service.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.bobo.blog.dao.imp1.CommentDao;
import com.bobo.blog.model.Comment;
import com.bobo.blog.response.CommandResponse;
import com.bobo.blog.service.CommandService;

@Service("commentDeleteService")
public class CommentDeleteService implements CommandService {
	@Autowired
	CommentDao commentDao;

	@Override
	public CommandResponse invoke(String requestContent) {
		Comment comment = JSON.parseObject(requestContent, Comment.class);
		commentDao.delete(comment);
		return null;
	}

}
