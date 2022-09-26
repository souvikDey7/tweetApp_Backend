package com.twitters.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twitters.business.dbadapter.dao.PostDao;
import com.twitters.business.dbadapter.service.SearchDBservice;

import be.twitter.customerdistribution.types.PostDetails;
import be.twitter.customerdistribution.types.User;

@Service
public class ServiceServiceImpl implements SearchService {

	@Autowired
	private SearchDBservice searchDBservice;

	@Override
	public List<PostDetails> getAll(Integer page) {

		return searchDBservice.getAll(page);
	}

	@Override
	public List<User> getAllUser(Integer page) {
		return searchDBservice.getAllUser(page);
	}

	@Override
	public List<User> getAllUserBySearchedUserName(String username,Integer page) {
		return searchDBservice.getAllUserBySearchedUserName(username,page);
	}

	@Override
	public List<PostDetails> getTweetByOwnId(String username,Integer page) {
		return searchDBservice.getTweetByOwnId(username,page);
	}

}
