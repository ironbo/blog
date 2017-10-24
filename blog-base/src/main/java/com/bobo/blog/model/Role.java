package com.bobo.blog.model;

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
@Table(name="BLOG_ROLE")
@DynamicInsert(true)
@DynamicUpdate(true)
public class Role {
	private int id;
	@JSONField(name="role_name")
	private String roleName;
	private String desc;

	@Id
	@Column(name = "ID", length = 10)
	@SequenceGenerator(name = "seq", sequenceName = "BLOG_ROLE_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator="seq",strategy=GenerationType.SEQUENCE)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "ROLE_NAME", length = 10, unique = true)
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Column(name = "DESCRIBE", length = 100, nullable = false)
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(int id, String roleName, String desc) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.desc = desc;
	}

}
