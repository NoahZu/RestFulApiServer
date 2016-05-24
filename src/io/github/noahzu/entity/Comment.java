package io.github.noahzu.entity;

import java.util.Date;

public class Comment {
	public Comment(int commentId, String content, String date, int userId) {
		super();
		this.commentId = commentId;
		this.content = content;
		this.date = date;
		this.userId = userId;
	}
	public int commentId;
	public String content;
	public String date;
	public int userId;
}
