package io.github.noahzu.handlers;

import io.github.noahzu.constant.Configs;
import io.github.noahzu.controller.RequestBaseHandler;
import io.github.noahzu.core.HttpRequest;

public class DefaultRequestHandler extends RequestBaseHandler {

	public DefaultRequestHandler() {
		super(Configs.DEFAULT_CONTEXT);
	}
	
	@Override
	public String handleRequest(HttpRequest request) {
		return "欢迎使用RestfulApiServer！！\n如果有任何问题可以访问https://github.com/NoahZu/RestfulApiServer\n谢谢";	
	}

}
