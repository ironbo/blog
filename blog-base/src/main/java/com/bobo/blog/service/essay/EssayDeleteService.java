package com.bobo.blog.service.essay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.bobo.blog.dao.imp1.CommentDao;
import com.bobo.blog.dao.imp1.EssayDao;
import com.bobo.blog.dao.imp1.LikedContentDao;
import com.bobo.blog.model.Essay;
import com.bobo.blog.response.CommandResponse;
import com.bobo.blog.response.DefaultCommandResponse;
import com.bobo.blog.service.CommandService;

@Service("essayDeleteService")
public class EssayDeleteService implements CommandService {
	@Autowired
	EssayDao essayDao;
	@Autowired
	CommentDao commentDao;
	@Autowired
	LikedContentDao likedContentDao;

	@Transactional
	@Override
	public CommandResponse invoke(String requestContent) {
		Essay essay = JSON.parseObject(requestContent, Essay.class);
		DefaultCommandResponse response = new DefaultCommandResponse();
		essayDao.delete(essay);
		commentDao.deleteByEssay(essay.getId());
		likedContentDao.deleteByEssay(essay.getId());
		return response;
	}

}
