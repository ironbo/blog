package com.bobo.blog.service.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.bobo.blog.dao.imp1.CommentDao;
import com.bobo.blog.model.Comment;
import com.bobo.blog.response.CommandResponse;
import com.bobo.blog.service.CommandService;

@Service("commentUpadateService")
public class CommentUpdateService implements CommandService {
	@Autowired
	CommentDao commentDao;
	@Override
	public CommandResponse invoke(String requestContent) {
		Comment comment = JSON.parseObject(requestContent, Comment.class);
		commentDao.update(comment);
		return null;
	}

}
