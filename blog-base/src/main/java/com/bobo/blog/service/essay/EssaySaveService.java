package com.bobo.blog.service.essay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.bobo.blog.dao.imp1.EssayDao;
import com.bobo.blog.model.Essay;
import com.bobo.blog.response.CommandResponse;
import com.bobo.blog.response.DefaultCommandResponse;
import com.bobo.blog.service.CommandService;

@Service("essaySaveService")
public class EssaySaveService implements CommandService {
	@Autowired
	EssayDao essayDao;

	@Transactional
	@Override
	public CommandResponse invoke(String requestContent) {
		Essay essay = JSON.parseObject(requestContent, Essay.class);
		DefaultCommandResponse response = new DefaultCommandResponse();
		essayDao.save(essay);
		return response;
	}

}
