package com.bobo.blog.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bobo.blog.dao.imp1.UserDao;
import com.bobo.blog.response.CommandResponse;
import com.bobo.blog.response.DefaultCommandResponse;
import com.bobo.blog.service.CommandService;

@Service("isUsernameUniqueService")
public class IsUsernameUniqueService implements CommandService {
	
	@Autowired
	UserDao userDao;

	@Transactional
	@Override
	public CommandResponse invoke(String requestContent) {
		DefaultCommandResponse response = new DefaultCommandResponse();
		JSONObject requestJson = JSON.parseObject(requestContent);
		String username = requestJson.getString("username");
		Boolean isUnique = userDao.IsUsernameUnique(username);
		response.setData(isUnique.toString());
		return response;
	}

}
