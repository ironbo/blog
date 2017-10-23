package com.bobo.blog.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.bobo.blog.base.ExceptionCode;

public class DefaultCommandResponse implements CommandResponse {

	@JSONField(name = CommandResponse.RET_CODE_NAME)
	private String retCode = ExceptionCode.SUCCESS.getCode();
	@JSONField(name = CommandResponse.RET_MSG_NAME)
	private String retMsg = ExceptionCode.SUCCESS.getDesc();
	private Object data;

	public String getRetCode() {
		return retCode;
	}

	public String getRetMsg() {
		return retMsg;
	}

	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}

	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
