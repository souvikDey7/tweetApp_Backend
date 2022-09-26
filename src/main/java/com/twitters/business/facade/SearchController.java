package com.twitters.business.facade;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.twitters.business.mapper.SearchMapper;
import com.twitters.business.security.JwtUtils;
import com.twitters.business.service.SearchService;

import be.twitter.customerdistribution.api.AllApi;
import be.twitter.customerdistribution.api.UserApi;
import be.twitter.customerdistribution.api.UsernamesApi;
import be.twitter.customerdistribution.api.UsersApi;
import be.twitter.customerdistribution.types.PostDetails;
import be.twitter.customerdistribution.types.User;
import be.twitter.customerdistribution.types.Userprofile;

@RestController
@RequestMapping("/api/v1.0/tweets")
@CrossOrigin(origins="*",methods = {RequestMethod.POST,RequestMethod.OPTIONS,RequestMethod.GET
		,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.HEAD})
public class SearchController implements AllApi, UsersApi, UserApi, UsernamesApi {

	Logger logger = LoggerFactory.getLogger(SearchController.class);

	@Autowired
	private SearchService searchService;

	@Autowired
	private SearchMapper searchMapper;

	@Autowired
	private JwtUtils jwt;

	@Override
	public ResponseEntity<List<PostDetails>> getAllTweetByAUserName(@NotNull @Valid String userid, String tokenKey,
			Integer page) {
		if (!jwt.validateToken(tokenKey))
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		return new ResponseEntity<>(searchService.getTweetByOwnId(userid,page), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<User>> getAllUserBySearchedUserName(String username, String tokenKey, Integer page) {
		if (!jwt.validateToken(tokenKey))
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		return new ResponseEntity<>(searchService.getAllUserBySearchedUserName(username,page), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<User>> getAllUser(String tokenKey, Integer page) {
		if (!jwt.validateToken(tokenKey))
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		return new ResponseEntity<>(searchService.getAllUser(page), HttpStatus.OK);

	}

	@Override
	public ResponseEntity<List<PostDetails>> getAllTweet(String tokenKey, Integer page) {
		if (!jwt.validateToken(tokenKey))
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		return new ResponseEntity<>(searchService.getAll(page), HttpStatus.OK);
	}

}
