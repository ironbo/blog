package com.bobo.blog.service;

import com.bobo.blog.response.CommandResponse;

public interface CommandService {

	public CommandResponse invoke(String requestContent);

}
