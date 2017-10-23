package com.bobo.blog.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

public class MySecurityMetadataSource implements FilterInvocationSecurityMetadataSource,InitializingBean {

	public static Map<RequestMatcher, Collection<ConfigAttribute>> requestMap;

	public MySecurityMetadataSource() {
		requestMap = new LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>>();
	}

	public MySecurityMetadataSource(LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> requestMap1) {
		requestMap = requestMap1;
	}

	public Collection<ConfigAttribute> getAllConfigAttributes() {
		Set<ConfigAttribute> allAttributes = new HashSet<ConfigAttribute>();

		for (Map.Entry<RequestMatcher, Collection<ConfigAttribute>> entry : requestMap.entrySet()) {
			allAttributes.addAll(entry.getValue());
		}

		return allAttributes;
	}

	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		final HttpServletRequest request = ((FilterInvocation) object).getRequest();
		System.out.println(1);
		for (Map.Entry<RequestMatcher, Collection<ConfigAttribute>> entry : requestMap.entrySet()) {
			System.out.println(entry.getKey());
			if (entry.getKey().matches(request)) {
				return entry.getValue();
			}
		}
		return null;
	}

	public boolean supports(Class<?> arg0) {
		
		return true;
	}

	public void afterPropertiesSet() throws Exception {
		loadAuthority();

	}
	
	public synchronized void loadAuthority()throws Exception{
		initDefaultMain("MAIN_FORWARD", "/forward");
		initDefaultMain("MAIN_INVOKE", "/invoke");
	}


	public void initDefaultMain(String auth,String url){
		ConfigAttribute configAttribute = new SecurityConfig(auth);
		RequestMatcher matcher = new AntPathRequestMatcher(url);
		Collection<ConfigAttribute> configAttributes =  new ArrayList<ConfigAttribute>();
		configAttributes.add(configAttribute);
		requestMap.put(matcher, configAttributes);
	}
}
