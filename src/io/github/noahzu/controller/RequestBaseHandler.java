package io.github.noahzu.controller;

import java.io.IOException;
import java.io.OutputStream;

import io.github.noahzu.constant.StatusCode;
import io.github.noahzu.core.HttpRequest;

public abstract class RequestBaseHandler {
	private RequestBaseFilter mRequestFilter = null;
	private HttpRequest mRequest;
	
	/**
	 * 空的构造函数
	 */
	public RequestBaseHandler(){
		
	}
	/**
	 * 带有一个过滤器的构造函数
	 * @param requestFilter
	 */
	public RequestBaseHandler(RequestBaseFilter requestFilter){
		this.mRequestFilter = requestFilter;
	}
	
	public void handle(HttpRequest request) throws IOException{
		mRequest = request;
		if(mRequestFilter != null){
			request = mRequestFilter.onFilter(request);
		}//先通过过滤器
		String responseString  = handleRequest(request);
		sendResponse(responseString,request);
	}
	
	/**
	 * 发送响应
	 * @param responseString
	 * @param request
	 * @throws IOException 
	 */
	private void sendResponse(String responseString,HttpRequest request) throws IOException {
		request.getExchange().sendResponseHeaders(StatusCode.REPONSE_SUCCESS, responseString.length());
        OutputStream os = request.getExchange().getResponseBody();
        os.write(responseString.getBytes());
        os.close();
	}
	/**
	 * 设置过滤器
	 * @param requestFilter
	 */
	public void setFilter(RequestBaseFilter requestFilter){
		this.mRequestFilter = requestFilter;
	}
	/**
	 * 由子类实现具体逻辑
	 * @param request
	 * @return
	 */
	abstract public String handleRequest(HttpRequest request);
	/**
	 * 注册成为观察者
	 */
	public void init(){
		RequestController.getInstance().addRequest(this);
	}
}
