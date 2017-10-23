package com.bobo.blog.service.likedContent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.bobo.blog.dao.imp1.LikedContentDao;
import com.bobo.blog.model.LikedContent;
import com.bobo.blog.response.CommandResponse;
import com.bobo.blog.response.DefaultCommandResponse;
import com.bobo.blog.service.CommandService;
@Service("likedCancelService")
public class LikedCancelService implements CommandService {
	@Autowired
	LikedContentDao likedContentDao;

	@Transactional
	@Override
	public CommandResponse invoke(String requestContent) {
		DefaultCommandResponse response = new DefaultCommandResponse();
		LikedContent likedContent = JSON.parseObject(requestContent, LikedContent.class);
		likedContentDao.delete(likedContent);
		return response;
	}

}
