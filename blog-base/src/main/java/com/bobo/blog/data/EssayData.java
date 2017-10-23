package com.bobo.blog.data;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class EssayData {
	private int id;
	@JSONField(name = "author_id")
	private int authorId;
	@JSONField(name = "pic_path")
	private String picPath;
	private String subject;
	private String content;
	@JSONField(name = "create_time")
	private String createTime;
	@JSONField(name = "update_time")
	private Date updateTime;
	private String weather;
	@JSONField(name = "liked_num")
	private int likedNum;
	@JSONField(name = "comment_num")
	private int commentNum;
	private String isShare;
	private String isLiked;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getPicPath() {
		return picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public int getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}

	public int getLikedNum() {
		return likedNum;
	}

	public void setLikedNum(int likedNum) {
		this.likedNum = likedNum;
	}

	public String getIsShare() {
		return isShare;
	}

	public void setIsShare(String isShare) {
		this.isShare = isShare;
	}

	public String getIsLiked() {
		return isLiked;
	}

	public void setIsLiked(String isLiked) {
		this.isLiked = isLiked;
	}

}
