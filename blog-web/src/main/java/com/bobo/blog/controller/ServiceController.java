package com.bobo.blog.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.bobo.blog.WebDispatcher;
import com.bobo.blog.base.HttpUtil;


@RestController
public class ServiceController {

	
	@Autowired
	WebDispatcher webDispatcher;

	@RequestMapping(value = { "/invoke" })
	public JSONObject handle(HttpServletRequest request) {
		JSONObject requestContent = HttpUtil.getRequestData();	
		JSONObject responseContent = webDispatcher.dispatcher(requestContent);
		return responseContent;

	}
	@RequestMapping(value = { "/register" })
	public JSONObject register(HttpServletRequest request) {
		JSONObject requestContent = HttpUtil.getRequestData();	
		JSONObject responseContent = webDispatcher.dispatcher(requestContent);
		return responseContent;
	}
}
