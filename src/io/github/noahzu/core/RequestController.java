package io.github.noahzu.core;

import io.github.noahzu.controller.RequestBaseHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class RequestController implements HttpHandler {
	private static RequestController requestController = null;
	private static List<RequestBaseHandler> handlers = null;
	
	private RequestController(){
		handlers = new ArrayList<RequestBaseHandler>();
	}
	
	public static RequestController getInstance(){
		if(requestController == null){
			synchronized (RequestController.class) {
				if(requestController == null){
					requestController = new RequestController();
				}
			}
		}
		return requestController;
	}
	
	@Override
	public void handle(HttpExchange httpExchange) throws IOException {
		//寻找出匹配的请求处理器来出来
		for(RequestBaseHandler handler : handlers){
			if(handler.getContext().equals(httpExchange.getHttpContext().getPath())){
				handler.handle(new HttpRequest(httpExchange));				
			}
		}
	}

	/**
	 * 将请求的handler注册到Controller
	 * @param handler
	 */
	public static void addRequest(RequestBaseHandler handler){
		if(handlers != null && !handlers.contains(handler)){
			handlers.add(handler);
		}
	}
}
