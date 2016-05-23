package io.github.noahzu.handlers;

import io.github.noahzu.controller.RequestBaseHandler;
import io.github.noahzu.entity.HttpRequest;

public class TalkRequestHandler extends RequestBaseHandler {

	
	
	public TalkRequestHandler(){
		super();	
	}
	
	@Override
	public String handleRequest(HttpRequest request) {
		//TODO 执行具体的获取数据的逻辑
		return "this is talk request";
	}
	
}
