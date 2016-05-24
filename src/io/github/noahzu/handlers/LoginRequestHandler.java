package io.github.noahzu.handlers;

import org.nutz.json.Json;

import com.sun.net.httpserver.HttpExchange;

import io.github.noahzu.constant.Configs;
import io.github.noahzu.controller.RequestBaseHandler;
import io.github.noahzu.core.HttpRequest;
import io.github.noahzu.db.MySqlHandler;
import io.github.noahzu.entity.User;

public class LoginRequestHandler extends RequestBaseHandler {

	public LoginRequestHandler() {
		super(Configs.LOGIN_CONTEXT);
	}

	@Override
	public String handleRequest(HttpRequest request) {
		HttpExchange exchange = request.getExchange();
		String userName = exchange.getAttribute("userName") == null ? "" : exchange.getAttribute("userName").toString();
		String passWord = exchange.getAttribute("passWord") == null ? "" : exchange.getAttribute("passWord").toString();
		if(userName.equals("") || passWord.equals("")){
			return "false";
		}
		User user = checkUser(new User(userName,passWord));
		if(user == null){
			return "false";
		}
		return Json.toJson(user);
	}

	/**
	 * 检查用户登录
	 * @param user
	 * @return
	 */
	private User checkUser(User user) {
		MySqlHandler userHandler = new MySqlHandler();
		return userHandler.userLogin(user);
	}

}
