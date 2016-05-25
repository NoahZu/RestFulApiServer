package io.github.noahzu.controller;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.net.URI;

import org.nutz.lang.stream.StringOutputStream;

import com.sun.net.httpserver.HttpExchange;

import io.github.noahzu.constant.StatusCode;
import io.github.noahzu.core.HttpRequest;
import io.github.noahzu.core.RequestController;

public abstract class RequestBaseHandler {
	private RequestBaseFilter mRequestFilter = null;
	private HttpRequest mRequest;
	private String mContext;
	
	/**
	 * 空的构造函数
	 */
	public RequestBaseHandler(String context){
		this.mContext = context;
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
		boolean b = mRequestFilter == null ? false : mRequestFilter.onFilter(request);
		if(!b){
			String responseString  = handleRequest(request);
			sendResponse(responseString,request);			
		}
	}
	
	/**
	 * 发送响应
	 * @param responseString
	 * @param request
	 * @throws IOException 
	 */
	private void sendResponse(String responseString,HttpRequest request) throws IOException {
		request.getExchange().sendResponseHeaders(StatusCode.REPONSE_SUCCESS, responseString.getBytes().length);
        OutputStream os = request.getExchange().getResponseBody();
        OutputStreamWriter writer = new OutputStreamWriter(os,"utf-8");
        writer.write(responseString);
        writer.flush();
        writer.close();
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
	
	public String getContext(){
		return mContext;
	}
	
	public String getRequestURIparameter(String key,HttpExchange exchange){
		String uri = exchange.getRequestURI().getQuery();
		String[] params = uri.split("&");
		for(String param : params){
			if(param.split("=")[0].equals(key)){
				return param.split("=")[1];
			}
		}
		return "";
	}
}

