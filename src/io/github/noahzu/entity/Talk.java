package io.github.noahzu.entity;

import java.util.List;

public class Talk {
	public int talkId;
	public String date;
	public String content;
	public User owner;
	public List<Comment> comments;
	public boolean isSift;
	public List<Integer> likes;//点赞的用户的id
}
