package io.github.noahzu.entity;

import java.util.List;

public class User {
	public User(){
		
	}
	public User(String userName, String passWord) {
		super();
		this.userName = userName;
		this.passWord = passWord;
	}
	public String userName;
	public String passWord;
	public String shortIntroduce;
	public String iconUrl;
	public List<Talk> collections;//收藏
	
}
