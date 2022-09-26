package com.twitters.business.service;

import java.util.List;

import be.twitter.customerdistribution.types.ReplyDetails;

public interface TweetUpsertService {
	String addPost(String username, String post);

	String deletePost(String username, String id);

	String editPost(String username, String post, String id);

	Integer addLike(String username, String id, Boolean flag);

	String addReply(String username, String id, String reply);
	
	List<ReplyDetails>  getReply(String id);
}
