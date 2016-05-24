package io.github.noahzu.core;

import io.github.noahzu.constant.Configs;
import io.github.noahzu.handlers.CommitTalkRequestHandler;
import io.github.noahzu.handlers.DefaultRequestHandler;
import io.github.noahzu.handlers.FetchTalkRequestHandler;
import io.github.noahzu.handlers.LoginRequestHandler;


public class MainApplication {
	
	public static void main(String[] args) {
		RequestDispatcher requestDispatcher = new RequestDispatcher(Configs.PORT_NUMBER, "", 1000);
		requestDispatcher.addContext(Configs.TALK_CONTEXT);
		requestDispatcher.addContext(Configs.COMMIT_TALK_CONTEXT);
		requestDispatcher.addContext(Configs.LOGIN_CONTEXT);
		requestDispatcher.start();
		
		new DefaultRequestHandler().init();//启动一个默认的请求处理器
		new FetchTalkRequestHandler().init();
		new CommitTalkRequestHandler().init();
		new LoginRequestHandler().init();
	}
	
	
}
