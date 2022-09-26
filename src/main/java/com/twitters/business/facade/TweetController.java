package com.twitters.business.facade;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.twitters.business.security.JwtUtils;
import com.twitters.business.service.RegisterService;
import com.twitters.business.service.TweetUpsertService;

import be.twitter.customerdistribution.api.ReplyApi;
import be.twitter.customerdistribution.api.UsernameApi;
import be.twitter.customerdistribution.types.Post;
import be.twitter.customerdistribution.types.ReplyDetails;

@RestController
@RequestMapping("/api/v1.0/tweets")
@CrossOrigin(origins="*",methods = {RequestMethod.POST,RequestMethod.OPTIONS,RequestMethod.GET
		,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.HEAD})
public class TweetController implements UsernameApi,ReplyApi {

	@Autowired
	private RegisterService registerService;

	@Autowired
	private TweetUpsertService tweetUpsertService;

	@Autowired
	private JwtUtils jwt;

	@Override
	public ResponseEntity<Integer> addLike(String username, String id, Boolean flag, String tokenKey) {
		if (!jwt.validateToken(tokenKey))
			return new ResponseEntity<Integer>(HttpStatus.UNAUTHORIZED);
		return new ResponseEntity<Integer>(tweetUpsertService.addLike(username, id, flag), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> deletePost(String username, String id, String tokenKey) {
		if (!jwt.validateToken(tokenKey))
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		return new ResponseEntity<>(tweetUpsertService.deletePost(username, id), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> resetPassword(String username) {
		return new ResponseEntity<>(registerService.resetPassword(username), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> addPost(String username, String tokenKey, @Valid Post post) {
		if (!jwt.validateToken(tokenKey))
			return new ResponseEntity<>("Authentication error", HttpStatus.UNAUTHORIZED);
		return new ResponseEntity<>(tweetUpsertService.addPost(username, post.getPost()), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> editPost(String username, String id, String tokenKey, @Valid Post post) {
		if (!jwt.validateToken(tokenKey))
			return new ResponseEntity<>("Authentication error", HttpStatus.UNAUTHORIZED);
		return new ResponseEntity<>(tweetUpsertService.editPost(username, post.getPost(), id), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> setReply(String username, String id, String tokenKey, @Valid Post post) {
		if (!jwt.validateToken(tokenKey))
			return new ResponseEntity<>("Authentication error", HttpStatus.UNAUTHORIZED);
		return new ResponseEntity<>(tweetUpsertService.addReply(username, id, post.getPost()), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<ReplyDetails>> getReply(String id, String tokenKey) {
		if (!jwt.validateToken(tokenKey))
			return new ResponseEntity("Authentication error", HttpStatus.UNAUTHORIZED);
		return new ResponseEntity<>(tweetUpsertService.getReply(id), HttpStatus.OK);	
		}
}
