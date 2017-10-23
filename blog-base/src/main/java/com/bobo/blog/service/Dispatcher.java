package com.bobo.blog.service;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bobo.blog.base.ExceptionCode;
import com.bobo.blog.response.CommandResponse;
import com.bobo.blog.response.DefaultCommandResponse;
import com.bobo.blog.service.user.UsernameCheckService;

@Service
public class Dispatcher implements ApplicationContextAware, InitializingBean {
	private final static Logger logger = LogManager.getLogger(UsernameCheckService.class);
	private ApplicationContext context;
	private Map<String, CommandService> serviceMap;

	public String handle(String requestContent) {
		String response = "";
		CommandResponse commandResponse = null;
		try {
			JSONObject requestJson = JSON.parseObject(requestContent);
			String serviceId = requestJson.getString("service_id");
			logger.info("服务开始：{}", serviceId);
			CommandService service = serviceMap.get(serviceId);
			commandResponse = service.invoke(requestContent);
		} catch (Throwable e) {
			logger.info(e.getMessage());
			e.printStackTrace();
			commandResponse = new DefaultCommandResponse();
			commandResponse.setRetCode(ExceptionCode.SYSTEM_ERROR.getCode());
			commandResponse.setRetMsg(ExceptionCode.SYSTEM_ERROR.getDesc());
		}
		response = JSON.toJSONString(commandResponse);
		return response;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		serviceMap = context.getBeansOfType(CommandService.class);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		context = applicationContext;
	}
}
