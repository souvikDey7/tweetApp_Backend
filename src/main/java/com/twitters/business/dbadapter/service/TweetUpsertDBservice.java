package com.twitters.business.dbadapter.service;

import java.util.List;

import be.twitter.customerdistribution.types.ReplyDetails;

public interface TweetUpsertDBservice {

	String addPost(String username, String post);

	String editPost(String username, String post, String id);

	String deletePost(String id);

	Integer addLike(String username, String id, Boolean flag);

	String addReply(String username, String id, String reply);

	List<ReplyDetails>  getReply(String id);
}
