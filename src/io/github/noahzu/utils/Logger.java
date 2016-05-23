package io.github.noahzu.utils;

public class Logger {
	private static boolean isDebuging = true;
	
	public static void E(String tag,String error){
		if(isDebuging){
			System.err.println("TAG:"+ tag+"    --    ERROR:"+error);			
		}
	}
	
	public static void D(String tag,String debug){
		if(isDebuging){
			System.out.println("TAG:"+ tag+"    --    DEBUG:"+debug);
		}
	}
	
}
