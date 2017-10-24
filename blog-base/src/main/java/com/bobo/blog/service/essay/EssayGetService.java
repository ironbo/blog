package com.bobo.blog.service.essay;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bobo.blog.dao.imp1.CommentDao;
import com.bobo.blog.dao.imp1.EssayDao;
import com.bobo.blog.dao.imp1.LikedContentDao;
import com.bobo.blog.data.EssayData;
import com.bobo.blog.model.Essay;
import com.bobo.blog.response.CommandResponse;
import com.bobo.blog.response.Pagination;
import com.bobo.blog.service.CommandService;

@Service("essayGetService")
public class EssayGetService implements CommandService {
	@Autowired
	EssayDao essayDao;
	@Autowired
	LikedContentDao likedContentDao;
	@Autowired
	CommentDao commentDao;

	@Transactional
	@Override
	public CommandResponse invoke(String requestContent) {
		JSONObject requestJson = JSON.parseObject(requestContent);
		Pagination pagination = new Pagination(requestJson.getIntValue("offset"), requestJson.getIntValue("limit"));
		essayDao.getAll(pagination);
		List<EssayData> rows = new ArrayList<>();
		for (int i = 0; i < pagination.getRows().size(); i++) {
			Essay source = (Essay) pagination.getRows().get(i);
			EssayData target = new EssayData();
			BeanUtils.copyProperties(source, target);
			int likedNum = likedContentDao.countLikedNum(source.getId());
			int contentNum = commentDao.countCommentNum(source.getId());
			String isLiked = likedContentDao.isLiked(source.getId(), requestJson.getIntValue("user_id"));
			String createTime = SimpleDateFormat.getDateTimeInstance().format(source.getCreateTime());
			target.setLikedNum(likedNum);
			target.setCommentNum(contentNum);
			target.setIsLiked(isLiked);
			target.setCreateTime(createTime);
			rows.add(target);
		}

		pagination.setRows(rows);
		return pagination;
	}

}
