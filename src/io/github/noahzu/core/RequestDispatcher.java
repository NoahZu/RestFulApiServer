package io.github.noahzu.core;

import io.github.noahzu.constant.Configs;
import io.github.noahzu.handlers.DefaultRequestHandler;
import io.github.noahzu.utils.Logger;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

import com.sun.net.httpserver.HttpServer;

public class RequestDispatcher {
	private HttpServer mHttpServer = null;
	private String mAddress;
	private int mPortNumber;
	private int mMaxmum;
	private static String TAG = "RequestDispatcher";
	private List<String> mContexts;
	
	public RequestDispatcher(int portNumber){
		this(portNumber,null);
	}
	public RequestDispatcher(int portNumber,String address){
		this(portNumber,address,Integer.MAX_VALUE/2);
	}
	public RequestDispatcher(int portNumber,String address,int maxmum){
		this(portNumber,address,maxmum,null);
	}
	public RequestDispatcher(int portNumber,String address,int maxmum,Executor executor){
		try{
			if(address == null || address.equals("")){
				mHttpServer = HttpServer.create(new InetSocketAddress(portNumber), maxmum);				
			}else{
				mHttpServer = HttpServer.create(new InetSocketAddress(address,portNumber), maxmum);
			}
		}catch(IOException e){
			Logger.E(TAG, e.toString());
		}
		mHttpServer.createContext(Configs.DEFAULT_CONTEXT,RequestController.getInstance());
		mHttpServer.setExecutor(executor);
	}
	/**
	 * 添加上下文
	 * @param context
	 */
	public void addContext(String context){
		if(mContexts == null){
			mContexts = new ArrayList<String>();
		}
		if(!mContexts.contains(context)){
			mContexts.add(context);			
			mHttpServer.createContext(context,RequestController.getInstance());
		}
	}
	/**
	 * 启动
	 */
	public void start(){
		if(mHttpServer != null){
			Logger.D(TAG, "server start.");
			mHttpServer.start();
		}
	}
	
}
