package com.bobo.blog.service.user;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bobo.blog.dao.imp1.UserDao;
import com.bobo.blog.data.UserData;
import com.bobo.blog.model.User;
import com.bobo.blog.response.DefaultCommandResponse;
import com.bobo.blog.service.CommandService;

@Service("userInfoService")
public class UserInfoService implements CommandService {

	@Autowired
	UserDao userDao;

	@Transactional
	public DefaultCommandResponse invoke(String requestContent) {
		DefaultCommandResponse response = new DefaultCommandResponse();
		JSONObject requestJson = JSON.parseObject(requestContent);
		String username = requestJson.getString("username");
		User source = userDao.queryInfo(username);
		UserData target = new UserData();
		BeanUtils.copyProperties(source, target);
		response.setData(target);
		return response;
	}
}
