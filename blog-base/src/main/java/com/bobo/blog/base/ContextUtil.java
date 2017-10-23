package com.bobo.blog.base;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.bobo.blog.response.CommandResponse;

public class ContextUtil{
	

	
	public static Map<String, Object> convertExToMap(ExceptionCode ex){
		Map<String, Object> responseMap = new HashMap<String, Object>();
		responseMap.put(CommandResponse.RET_CODE_NAME, ex.getCode());
		responseMap.put(CommandResponse.RET_MSG_NAME, ex.getDesc());
		
		return responseMap;
	}
	public static Map<String, Object> convertExToMap(MyException ex){
		Map<String, Object> responseMap = new HashMap<String, Object>();
		responseMap.put(CommandResponse.RET_CODE_NAME, ex.getCode());
		responseMap.put(CommandResponse.RET_MSG_NAME, ex.getMessage());
		
		return responseMap;
	}
	public static String convertExToJsonStr(ExceptionCode ex){
		Map<String, Object> responseMap = convertExToMap(ex);
		
		return JSON.toJSONString(responseMap);
	}
	public static String convertExToJsonStr(MyException ex){
		Map<String, Object> responseMap = convertExToMap(ex);

		return JSON.toJSONString(responseMap);
	}
}
