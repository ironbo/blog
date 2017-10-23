package com.bobo.blog.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.bobo.blog.dao.imp1.UserDao;
import com.bobo.blog.model.User;
import com.bobo.blog.response.DefaultCommandResponse;
import com.bobo.blog.service.CommandService;

@Service("userUpadateService")
public class UserUpdateService implements CommandService {
	@Autowired
	UserDao userDao;

	@Transactional
	public DefaultCommandResponse invoke(String requestContent) {
		DefaultCommandResponse response = new DefaultCommandResponse();
		User user = JSON.parseObject(requestContent, User.class);
		userDao.update(user);
		return response;
	}
}
