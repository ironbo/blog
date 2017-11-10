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
@Table(name = "BLOG_ESSAY")
@DynamicInsert(true)
@DynamicUpdate(true)
public class Essay {

	private int id;
	@JSONField(name = "author_id")
	private int authorId;
	@JSONField(name = "pic_path")
	private String picPath;
	private String subject;
	private String content;
	@JSONField(name = "create_time")
	private Date createTime;
	@JSONField(name = "update_time")
	private Date updateTime;
	private String weather;
	// @JSONField(name = "liked_num")
	// private int likedNum;
	// @JSONField(name = "comment_num")
	// private int commentNum;
	@JSONField(name = "is_share")
	private String isShare;

	@Id
	@Column(name = "ID", length = 10)
//	@SequenceGenerator(name = "seq", sequenceName = "BLOG_ESSAY_SEQ", initialValue = 1, allocationSize = 1)
//	@GeneratedValue(generator = "seq", strategy = GenerationType.SEQUENCE)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "AUTHOR_ID", length = 10)
	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	@Column(name = "PIC_PATH", length = 50)
	public String getPicPath() {
		return picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	@Column(name = "subject", length = 50)
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Column(name = "CONTENT", length = 2000)
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

	@Column(name = "UPDATE_TIME")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "WEATHER", length = 20)
	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	// @Column(name = "COMMENT_NUM", length = 10)
	// public int getCommentNum() {
	// return commentNum;
	// }
	//
	// public void setCommentNum(int commentNum) {
	// this.commentNum = commentNum;
	// }
	//
	// @Column(name = "LIKED_NUM", length = 10)
	// public int getLikedNum() {
	// return likedNum;
	// }
	//
	// public void setLikedNum(int likedNum) {
	// this.likedNum = likedNum;
	// }

	@Column(name = "IS_SHARE", columnDefinition = "varchar(1) default 0")
	public String getIsShare() {
		return isShare;
	}

	public void setIsShare(String isShare) {
		this.isShare = isShare;
	}

}
