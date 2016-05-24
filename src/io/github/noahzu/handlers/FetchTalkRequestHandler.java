package io.github.noahzu.handlers;

import io.github.noahzu.constant.Configs;
import io.github.noahzu.controller.RequestBaseHandler;
import io.github.noahzu.core.HttpRequest;
import io.github.noahzu.dao.TalkDao;
import io.github.noahzu.entity.Talk;

import java.util.List;

import org.nutz.json.Json;

public class FetchTalkRequestHandler extends RequestBaseHandler {

	
	
	public FetchTalkRequestHandler(){
		super(Configs.TALK_CONTEXT);	
	}
	
	@Override
	public String handleRequest(HttpRequest request) {
		List<Talk> talks = new TalkDao().getTalk(0, 0);
		String json = Json.toJson(talks);
		return json;	
	}
	
}
