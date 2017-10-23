package com.bobo.blog.base;

import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class HttpUtil {

	public static HttpServletRequest getReqeust() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}

	public static HttpServletResponse getResponse() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
	}

	public static Object getValue(String value) {
		if (value.startsWith("[") && value.endsWith("]")) {
			JSONArray array = JSON.parseArray(value);
			return array;
		}
		if (value.startsWith("{") && value.endsWith("}")) {
			return JSON.parseObject(value);
		}
		return value;

	}

	public static JSONObject getRequestData() {
		HttpServletRequest request = getReqeust();
		Map<String, String[]> paramters = request.getParameterMap();
		JSONObject json = new JSONObject();
		for (Entry<String, String[]> entry : paramters.entrySet()) {
			json.put(entry.getKey(), getValue(entry.getValue()[0]));
		}
		return json;
	}
}
