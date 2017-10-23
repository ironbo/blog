package com.bobo.blog.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bobo.blog.WebDispatcher;

public class MySimpleUrlAuthenticationSuccessHandler extends AbstractAuthenticationTargetUrlRequestHandler
		implements AuthenticationSuccessHandler {
	@Autowired
	WebDispatcher webDispatcher;

	public MySimpleUrlAuthenticationSuccessHandler() {
	}

	public MySimpleUrlAuthenticationSuccessHandler(String defaultTargetUrl) {
		setDefaultTargetUrl(defaultTargetUrl);
	}

	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		JSONObject requestJson = new JSONObject();
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		requestJson.put("username", username);
		requestJson.put("service_id", "userInfoService");
		JSONObject responseJson = webDispatcher.dispatcher(requestJson);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.write(JSON.toJSONString(responseJson));
		writer.flush();
		writer.close();
		clearAuthenticationAttributes(request);
	}

	protected final void clearAuthenticationAttributes(HttpServletRequest request) {
		HttpSession session = request.getSession(false);

		if (session == null) {
			return;
		}

		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	}

}
