package com.bobo.blog;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.bobo.blog.service.Dispatcher;

@Component
public class WebDispatcher {
	private final static Logger logger = LogManager.getLogger(WebDispatcher.class);
	@Autowired
	Dispatcher dispatcher;
	@Autowired
	@Qualifier("passwordEncoder")
	BCryptPasswordEncoder passwordEncoder;

	public JSONObject dispatcher(JSONObject requestJson) {

		if (requestJson.containsValue("registerService")) {
			String password = passwordEncoder.encode(requestJson.getString("password"));
			requestJson.put("password", password);
		}
		if (requestJson.containsValue("userInfoService")) {
			String username = requestJson.getString("username");
			if(username == null || username == "")
				username = SecurityContextHolder.getContext().getAuthentication().getName();
			requestJson.put("username", username);
		}
		String requestContent = requestJson.toJSONString();
		logger.info("发送报文：{}", requestContent);
		String responseContent = dispatcher.handle(requestContent);
		logger.info("接收报文：{}", responseContent);
		return JSONObject.parseObject(responseContent);
	}

}
