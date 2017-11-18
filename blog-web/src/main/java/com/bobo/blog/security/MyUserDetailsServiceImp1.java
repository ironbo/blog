package com.bobo.blog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.alibaba.fastjson.JSONObject;
import com.bobo.blog.WebDispatcher;

public class MyUserDetailsServiceImp1 implements UserDetailsService {

	@Autowired
	WebDispatcher webDispatcher;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		JSONObject requestContent = new JSONObject();
		requestContent.put("username", username);
		requestContent.put("service_id", "usernameCheckService");
		JSONObject responseJson = webDispatcher.dispatcher(requestContent);
		String password = responseJson.getString("password");
		System.out.println(password);
		MyUserDetails userDetails = new MyUserDetails(username, password);
		return userDetails;
	}

}
