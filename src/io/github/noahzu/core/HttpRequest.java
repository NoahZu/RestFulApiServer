package io.github.noahzu.core;

import com.sun.net.httpserver.HttpExchange;


public class HttpRequest {
	private HttpExchange mHttpExchange = null;
	private String mRequestMethod = "";
	
	public HttpRequest(HttpExchange httpExchange){
		this.mHttpExchange = httpExchange;
		this.mRequestMethod = httpExchange.getRequestMethod();
	}
	
	public HttpExchange getExchange(){
		return this.mHttpExchange;
	}
	
}
