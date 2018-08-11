介绍：一个简单的用java实现的服务器
使用方法
一、继承RequestBaseHandler
继承此类以后，实现他的handleRequest方法，handleRequest方法传进来的是HttpRequest类，此类封装了请求的信息，比如请求头，请求体等等。在此处实现自己的业务逻辑，然后将结果返回，返回的就是response的结果。比如：

	public class TalkRequestHandler extends RequestBaseHandler {
		public TalkRequestHandler(){
			super();	
		}
		
		@Override
		public String handleRequest(HttpRequest request) {
			//TODO 执行具体的获取数据的逻辑
			return "this is talk request";
		}	
	}
	
二、创建一个入口类（也就是有main函数的类），在入口的类中启动请求分发器，注册自己的请求处理类，比如：
	
	public class MainApplication {
		
		public static void main(String[] args) {
			new RequestDispatcher(Configs.TALK_CONTEXT, Configs.PORT_NUMBER, "", 1000).start();//启动请求分发器
			new TalkRequestHandler().init();//初始化talk请求，这就意味着可以接受这个请求
		}
	}

三、关于配置
	在Configs.java中配置信息：

四、关于
	如有任何问题，请与我联系 email:smallzoo@foxmail.com

五、关于json转换库
	http://nutzam.com/core/json/to.html

六、api
	http://139.129.59.163:8000/Talk?page=1&pagesize=10   获取所有的talk
	http://139.129.59.163:8000/Login  将用户名和密码放在post请求中，字段分别为userName passWord
		比如：http://localhost:8000/Login?userName=admin&passWord=123
	http://139.129.59.163:8000/CommitTalk 将提交的内容放在post请求中 字段为content
	 
	
