package com.bobo.blog.service.user;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.bobo.blog.base.ExceptionCode;
import com.bobo.blog.dao.imp1.RoleDao;
import com.bobo.blog.dao.imp1.UserDao;
import com.bobo.blog.model.Role;
import com.bobo.blog.model.User;
import com.bobo.blog.response.CommandResponse;
import com.bobo.blog.response.DefaultCommandResponse;
import com.bobo.blog.service.CommandService;

@Service("registerService")
public class RegisterService implements CommandService {
	private final static Logger logger = LogManager.getLogger(RegisterService.class);
	@Autowired
	UserDao userDao;
	@Autowired
	RoleDao roleDao;

	@Transactional
	@Override
	public CommandResponse invoke(String requestContent) {
		CommandResponse commandResponse = new DefaultCommandResponse();
		try {
			User user = JSON.parseObject(requestContent, User.class);
			if(user.getGender() != null && user.getGender().equals("女"))
				user.setGender("F");
			else
				user.setGender("M");
			Role role = roleDao.get(2, Role.class);
			List<Role> roles = user.getRoles();
			roles.add(role);
			user.setRoles(roles);
			userDao.save(user);
		} catch (Exception e) {
			logger.debug(e.getMessage());
			logger.info("注册服务异常，请查看debug日志");
			commandResponse.setRetCode(ExceptionCode.REGISTER_FAILURE.getCode());
			commandResponse.setRetMsg(ExceptionCode.REGISTER_FAILURE.getDesc());
		}
		return commandResponse;
	}

}
