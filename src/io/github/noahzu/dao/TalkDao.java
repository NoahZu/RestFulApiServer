package io.github.noahzu.dao;

import io.github.noahzu.entity.Comment;
import io.github.noahzu.entity.Talk;
import io.github.noahzu.entity.User;

import java.util.ArrayList;
import java.util.List;

public class TalkDao {
	
	public List<Talk> getTalk(int page,int pageSize){
		List<Talk> talks = new ArrayList<Talk>();
		for(int i = 0;i < 10;i++){
			Talk t = new Talk();
			t.talkId  = 1000;
			t.content = "this is content is "+ i + "ddd";
			t.date = "2015-5-24";
			t.isSift = true;
			t.owner =  new User();
			if(i == 4){
				t.comments = new ArrayList<Comment>();
				t.comments.add(new Comment(0001, "thisis", "2016-5-24", 0000));				
			}else{
				t.comments = null;
			}
			t.likes = new ArrayList<Integer>();
			t.likes.add(3);
			talks.add(t);
		}
		return talks;
	}
}
