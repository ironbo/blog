package com.bobo.blog.response;

public interface CommandResponse {
	public final static String RET_CODE_NAME = "code";
	public final static String RET_MSG_NAME = "msg";
	/**
	 * 设置命令结果
	 * @param retCode
	 */
	public void setRetCode(String retCode);
	/***
	 * 设置命令结果值
	 * @param retMsg
	 */
	public void setRetMsg(String retMsg);
}
