package com.twitters.business.service;

import java.util.List;
import java.util.Properties;
import java.util.UUID;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import com.fasterxml.jackson.databind.ser.std.UUIDSerializer;
import com.twitters.business.dbadapter.service.TweetUpsertDBservice;

import be.twitter.customerdistribution.types.ReplyDetails;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

@Service
public class TweetUpsertServiceImpl implements TweetUpsertService {

	@Autowired
	TweetUpsertDBservice tweetUpsertDBservice;

	@Override
	public String addPost(String username, String post) {
		return tweetUpsertDBservice.addPost(username, post);
	}

	@Override
	public String editPost(String username, String post, String id) {
		return tweetUpsertDBservice.editPost(username, post, id);
	}

	@Override
	public String deletePost(String username, String id) {
		return tweetUpsertDBservice.deletePost(id);
	}

	@Override
	public Integer addLike(String username, String id, Boolean flag) {
		return tweetUpsertDBservice.addLike(username, id, flag);
	}

	@Override
	public String addReply(String username, String id, String reply) {
		return tweetUpsertDBservice.addReply(username, id, reply);
	}

	@Override
	public List<ReplyDetails> getReply(String id) {
		return tweetUpsertDBservice.getReply(id);
		}
}
