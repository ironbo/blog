package com.bobo.blog.service.user;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bobo.blog.dao.imp1.UserDao;
import com.bobo.blog.response.PasswordResponse;
import com.bobo.blog.service.CommandService;

@Service("usernameCheckService")
public class UsernameCheckService implements CommandService {
	private final static Logger logger = LogManager.getLogger(UsernameCheckService.class);
	@Autowired
	UserDao userDao;

	@Transactional
	public PasswordResponse invoke(String requestContent) {
		PasswordResponse response = new PasswordResponse();
		JSONObject requestJson = JSON.parseObject(requestContent);
		String username = requestJson.getString("username");
		String password = userDao.queryPassword(username);
		response.setPassword(password);
		return response;

	}
}
