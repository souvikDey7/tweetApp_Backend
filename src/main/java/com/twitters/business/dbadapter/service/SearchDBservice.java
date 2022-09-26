package com.twitters.business.dbadapter.service;

import java.util.List;

import com.twitters.business.dbadapter.dao.PostDao;

import be.twitter.customerdistribution.types.PostDetails;
import be.twitter.customerdistribution.types.User;

public interface SearchDBservice {

	List<PostDetails> getAll(Integer page);

	List<User> getAllUser(Integer page);

	List<User> getAllUserBySearchedUserName(String username,Integer page);

	List<PostDetails> getTweetByOwnId(String username,Integer page);
}
