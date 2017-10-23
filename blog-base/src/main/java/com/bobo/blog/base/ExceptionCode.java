package com.bobo.blog.base;

public enum ExceptionCode {
	
	SUCCESS("0000", "请求成功"),
	LOGIN_SUCCESS("0001", "登录成功"),
	LOGIN_FAILURE("1001", "用户名或密码错误"),
	SYSTEM_ERROR("2000", "系统异常"),
	SESSION_EXPIRED("2001", "session已失效，请重新登录"),
	NOT_ALLOWED_OP("2002", "权限不足"),
	REGISTER_FAILURE("3000", "注册失败"),
	VALID_ERROR("3001", "数据格式错误"),
	DUPLICATE_INSERT("3002", "新增数据重复"),
	NO_RECORD("3003", "没有符合条件的记录"),
	;
	private String code;
	private String desc;
	
	private ExceptionCode(String code, String desc)
	{
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
