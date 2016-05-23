package io.github.noahzu;

import io.github.noahzu.constant.Configs;
import io.github.noahzu.handlers.TalkRequestHandler;
import jdk.nashorn.internal.runtime.regexp.joni.Config;

public class MainApplication {
	
	public static void main(String[] args) {
		new RequestDispatcher(Configs.TALK_CONTEXT, Configs.PORT_NUMBER, "", 1000).start();//启动请求分发器
		new TalkRequestHandler().init();//初始化talk请求，这就意味着可以接受这个请求
	}
}
