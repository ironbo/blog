package com.bobo.blog.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.bobo.blog.base.ContextUtil;
import com.bobo.blog.base.ExceptionCode;

public class MySimpleUrlAuthenticationFailureHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		String responseContent = ContextUtil.convertExToJsonStr(ExceptionCode.LOGIN_FAILURE);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.write(responseContent);
		writer.flush();
		writer.close();
		
	}

}
