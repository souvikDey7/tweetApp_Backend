package com.twitters.business.dbadapter.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.twitters.business.dbadapter.dao.PostDao;
import com.twitters.business.dbadapter.dao.UserDetailsDao;
import com.twitters.business.dbadapter.repository.PostRepository;
import com.twitters.business.dbadapter.repository.UserDetailsRepository;
import com.twitters.business.mapper.RegistrationMapper;

import be.twitter.customerdistribution.types.PostDetails;
import be.twitter.customerdistribution.types.User;

@Service
public class SearchDBserviceImpl implements SearchDBservice {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private UserDetailsRepository userDetailsRepository;

	@Autowired
	RegistrationMapper mapper;

	@Override
	public List<PostDetails> getAll(Integer page) {
		Pageable pageable = PageRequest.of(page, 4);
		Page<PostDao> all = postRepository.findAll(pageable);
		List<PostDetails> allTweet = new ArrayList<>();
		for (PostDao i : all) {
			PostDetails a = new PostDetails();
			a.setId(i.get_id());
			a.setLike(i.getLike());
			a.setPostData(i.getPostData());
			if (i.getTime() != null) {
				a.setTime(new SimpleDateFormat().format(i.getTime()));
			}
			a.setUserId(i.getUserId());
			allTweet.add(a);
		}
		return allTweet;
	}

	@Override
	public List<User> getAllUser(Integer page) {
		Pageable pageable = PageRequest.of(page, 4);
		Page<UserDetailsDao> users = userDetailsRepository.findAll(pageable);
		List<User> user = users.stream().map(userDetails -> mapper.toUser(userDetails)).collect(Collectors.toList());
		Collections.reverse(user);
		return user;
	}

	@Override
	public List<User> getAllUserBySearchedUserName(String username,Integer page) {
		Pageable pageable = PageRequest.of(page, 4);
		List<User> user = userDetailsRepository.findUserName(username, pageable).stream()
				.map(userDetails -> mapper.toUser(userDetails)).collect(Collectors.toList());
		return user;
	}

	@Override
	public List<PostDetails> getTweetByOwnId(String username,Integer page) {
//		Pageable pageable = PageRequest.of(page, 4);
	List<PostDetails> tweets = postRepository.findByUserId(username);
		Collections.reverse((List<?>) tweets);
		return tweets;
	}
}
