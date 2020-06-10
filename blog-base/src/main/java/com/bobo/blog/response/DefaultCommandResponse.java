package com.bobo.blog.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.bobo.blog.base.ExceptionCode;
import lombok.Data;

@Data
public class DefaultCommandResponse implements CommandResponse {

	@JSONField(name = CommandResponse.RET_CODE_NAME)
	private String retCode = ExceptionCode.SUCCESS.getCode();
	@JSONField(name = CommandResponse.RET_MSG_NAME)
	private String retMsg = ExceptionCode.SUCCESS.getDesc();
	private Object data;

}
