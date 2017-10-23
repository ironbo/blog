package com.bobo.blog.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


public class MyUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	public static final String mimiUsername = "username";
	public static final String mimiPassword = "password";

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		Authentication authentication = null;
		String username = obtainUsername(request);
		String password = obtainPassword(request);
		username = username.trim();
		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
				username, password);
		setDetails(request, authRequest);
		AuthenticationManager authenticationManager = this.getAuthenticationManager();
		authentication = authenticationManager.authenticate(authRequest);
		MyUserDetails detail = (MyUserDetails) authentication.getPrincipal();
		if(detail == null){
			throw new AuthenticationServiceException("认证信息为空"); 
		}
		return authentication;
	}

	@Override
	protected String obtainUsername(HttpServletRequest request) {
		String obj = request.getParameter(mimiUsername);
		return null == obj ? "" : obj;
	}

	@Override
	protected String obtainPassword(HttpServletRequest request) {
		String obj = request.getParameter(mimiPassword);
		return null == obj ? "" : obj;
	}

}
