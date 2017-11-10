package com.bobo.blog.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.alibaba.fastjson.annotation.JSONField;

@Entity
@Table(name = "BLOG_COMMENT")
@DynamicInsert(true)
@DynamicUpdate(true)
public class Comment {

	private int id;
	@JSONField(name = "essay_id")
	private int essayId;
	@JSONField(name = "user_id")
	private int userId;
	private String content;
	@JSONField(name = "create_time")
	private Date createTime;

	@Id
	@Column(name = "ID", length = 10)
//	@SequenceGenerator(name = "seq", sequenceName = "BLOG_COMMENT_SEQ", initialValue = 1, allocationSize = 1)
//	@GeneratedValue(generator = "seq", strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "ESSAY_ID", length = 10)
	public int getEssayId() {
		return essayId;
	}

	public void setEssayId(int essayId) {
		this.essayId = essayId;
	}

	@Column(name = "USER_ID", length = 10)
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name = "CONTENT", length = 500)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "CREATE_TIME")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
