package com.bobo.blog.model;
//package com.bobo.mimi.model;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.SequenceGenerator;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "BLOG_SUBCOMMENT")
//public class SubComment {
//	private int id;
//	private int commentId;
//	private int commentPId;
//	private int commentedPId;
//	private String content;
//	private String createTime;
//
//	@Id
//	@Column(name = "ID", length = 10)
//	@SequenceGenerator(name = "seq", sequenceName = "BLOG_SUBCOMMENT_SEQ", initialValue = 1, allocationSize = 1)
//	@GeneratedValue(generator = "seq", strategy = GenerationType.SEQUENCE)
//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}
//
//	@Column(name = "COMMENT_ID", length = 10)
//	public String getCommentId() {
//		return commentId;
//	}
//
//	public void setCommentId(String commentId) {
//		this.commentId = commentId;
//	}
//
//	@Column(name = "COMMENT_P_ID", length = 10)
//	public String getCommentPId() {
//		return commentPId;
//	}
//
//	public void setCommentPId(String commentPId) {
//		this.commentPId = commentPId;
//	}
//
//	@Column(name = "COMMENTED_P_ID", length = 10)
//	public String getCommentedPId() {
//		return commentedPId;
//	}
//
//	public void setCommentedPId(String commentedPId) {
//		this.commentedPId = commentedPId;
//	}
//
//	@Column(name = "CONTENT", length = 500)
//	public String getContent() {
//		return content;
//	}
//
//	public void setContent(String content) {
//		this.content = content;
//	}
//
//	@Column(name = "CREATE_TIME")
//	public String getCreateTime() {
//		return createTime;
//	}
//
//	public void setCreateTime(String createTime) {
//		this.createTime = createTime;
//	}
//
//	public SubComment() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public SubComment(String id, String commentId, String commentPId, String commentedPId, String content,
//			String createTime) {
//		super();
//		this.id = id;
//		this.commentId = commentId;
//		this.commentPId = commentPId;
//		this.commentedPId = commentedPId;
//		this.content = content;
//		this.createTime = createTime;
//	}
//
//}
