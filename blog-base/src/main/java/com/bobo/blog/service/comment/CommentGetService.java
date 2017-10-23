package com.bobo.blog.service.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bobo.blog.dao.imp1.CommentDao;
import com.bobo.blog.response.CommandResponse;
import com.bobo.blog.response.Pagination;
import com.bobo.blog.service.CommandService;

@Service("commentGetService")
public class CommentGetService implements CommandService {
	@Autowired
	CommentDao commentDao;

	@Override
	public CommandResponse invoke(String requestContent) {
		JSONObject requestJson = JSON.parseObject(requestContent);
		int essayId = requestJson.getIntValue("essay_id");
		Pagination pagination = new Pagination(requestJson.getIntValue("offset"), requestJson.getIntValue("limit"));
		commentDao.getAll(pagination, essayId);
		return pagination;
	}

}
