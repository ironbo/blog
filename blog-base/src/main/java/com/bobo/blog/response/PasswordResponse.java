package com.bobo.blog.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PasswordResponse extends DefaultCommandResponse {

	private String password;


}
