package com.bobo.blog.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

	@RequestMapping(value = { "/", "/login.html" })
	public String loginForm(HttpServletResponse response, HttpServletRequest request) {
		return "form_login";
	}

	@RequestMapping(value = { "/forward" })
	public String forward(HttpServletResponse response, HttpServletRequest request) {
		return "index";
	}
	@RequestMapping(value = { "/register_content.html" })
	public String register(HttpServletResponse response, HttpServletRequest request) {
		return "register";
	}
	
	@RequestMapping(value = { "/weixinTest" })
	public void weixinTest(HttpServletResponse response, HttpServletRequest request) throws IOException {
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		System.out.println("signature:" + signature);
		System.out.println("timestamp:" + timestamp);
		System.out.println("nonce:" + nonce);
		System.out.println("echostr:" + echostr);
		PrintWriter pw = response.getWriter();
		pw.append(echostr);
		pw.flush();
	}
}
