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
@Table(name = "BLOG_LIKED_CONTENT")
@DynamicInsert(true)
@DynamicUpdate(true)
public class LikedContent {
	private int id;
	@JSONField(name = "eassy_id")
	private int eassyId;
	@JSONField(name = "user_id")
	private int userId;
	private String flag;
	@JSONField(name = "create_time")
	private Date createTime;

	@Id
	@Column(name = "ID", length = 10)
	@SequenceGenerator(name = "seq", sequenceName = "BLOG_LIKED_CONTENT_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "seq", strategy = GenerationType.SEQUENCE)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "ESSAY_ID", length = 10)
	public int getEassyId() {
		return eassyId;
	}

	public void setEassyId(int eassyId) {
		this.eassyId = eassyId;
	}

	@Column(name = "USER_ID", length = 10)
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name = "FLAG", length = 10)
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	@Column(name = "CREATE_TIME")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public LikedContent() {
		super();
		// TODO Auto-generated constructor stub
	}

}
