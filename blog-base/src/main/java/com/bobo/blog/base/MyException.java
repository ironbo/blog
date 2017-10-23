package com.bobo.blog.base;

public class MyException extends RuntimeException {

	private static final long serialVersionUID = -1801789337469068440L;
	private String code = "";

	public MyException(String message) {
		super(message);
	}

	public MyException(ExceptionCode ex) {
		super(ex.getDesc());
		this.code = ex.getCode();
	}

	public MyException(String msg, String code) {
		this(msg);
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
