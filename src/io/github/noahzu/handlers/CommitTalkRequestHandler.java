package io.github.noahzu.handlers;


import com.sun.net.httpserver.HttpExchange;

import io.github.noahzu.constant.Configs;
import io.github.noahzu.controller.RequestBaseHandler;
import io.github.noahzu.core.HttpRequest;
import io.github.noahzu.utils.Logger;

public class CommitTalkRequestHandler extends RequestBaseHandler {

	private static final String TAG = "CommitTalkRequestHandler";

	public CommitTalkRequestHandler(){
		super(Configs.COMMIT_TALK);
	}
	
	@Override
	public String handleRequest(HttpRequest request) {
//		HttpExchange httpExchange = request.getExchange();
//		String content = httpExchange.getAttribute(Configs.COMMIT_TALK).toString();
//		Logger.D(TAG,content);
		return "true";
	}

}
