package io.github.noahzu;

import io.github.noahzu.controller.RequestController;
import io.github.noahzu.utils.Logger;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;

import com.sun.net.httpserver.HttpServer;

public class RequestDispatcher {
	private HttpServer mHttpServer = null;
	private String mContext;
	private String mAddress;
	private int mPortNumber;
	private int mMaxmum;
	private static String TAG = "RequestDispatcher";
	
	public RequestDispatcher(String context,int portNumber){
		this(context,portNumber,null);
	}
	public RequestDispatcher(String context,int portNumber,String address){
		this(context, portNumber,address,Integer.MAX_VALUE/2);
	}
	public RequestDispatcher(String context,int portNumber,String address,int maxmum){
		this(context,portNumber,address,maxmum,null);
	}
	public RequestDispatcher(String context,int portNumber,String address,int maxmum,Executor executor){
		mContext = context;
		try{
			if(address == null || address.equals("")){
				mHttpServer = HttpServer.create(new InetSocketAddress(portNumber), maxmum);				
			}else{
				mHttpServer = HttpServer.create(new InetSocketAddress(address,portNumber), maxmum);
			}
		}catch(IOException e){
			Logger.E(TAG, e.toString());
		}
		mHttpServer.createContext(context,RequestController.getInstance());
		mHttpServer.setExecutor(executor);
	}
	
	public void start(){
		if(mHttpServer != null){
			Logger.D(TAG, "context:"+mContext+"'s server start.");
			mHttpServer.start();
		}
	}
	
}
