package com.twitters.business.dbadapter.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.twitters.business.dbadapter.dao.PostDao;
import com.twitters.business.dbadapter.dao.ReplyDao;
import com.twitters.business.dbadapter.repository.PostRepository;
import com.twitters.business.dbadapter.repository.ReplyRepository;

import be.twitter.customerdistribution.types.ReplyDetails;

@Service
public class TweetUpsertDBserviceImpl implements TweetUpsertDBservice {
	@Autowired
	PostRepository postRepository;

	@Autowired
	ReplyRepository replyRepository;

	@Override
	public String addPost(String username, String post) {
		PostDao postDao = new PostDao();
		postDao.setPostData(post);
		Date now = Date.valueOf(LocalDate.now());
		postDao.setTime(now);
		postDao.setUserId(username);
		postRepository.save(postDao);
		return "post added";
	}

	@Override
	public String editPost(String username, String post, String id) {
		try {
			Optional<PostDao> postDao = postRepository.findById(id);
			postDao.get().setPostData(post);

			Date now = Date.valueOf(LocalDate.now());
			postDao.get().setTime(now);

			postRepository.save(postDao.get());
			return "updated successfully";
		} catch (Exception e) {
			return "error to update";
		}
	}

	@Override
	public String deletePost(String id) {
		try {
			postRepository.deleteById(id);
			return "post deleted";
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Integer addLike(String username, String id, Boolean flag) {
		try {
			Optional<PostDao> postDao = postRepository.findById(id);
			Integer like = postDao.get().getLike();
			if (flag)
				like++;
			else
				like--;
			postDao.get().setLike(like);
			postRepository.save(postDao.get());
			return like;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public String addReply(String username, String id, String reply) {
		try {
			ReplyDao replyDao = new ReplyDao();
			replyDao.setCommentId(id);
			replyDao.setReply(reply);
			replyDao.setUserId(username);
			replyRepository.save(replyDao);
			return "replied";
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<ReplyDetails> getReply(String id) {
		List<ReplyDetails> replys=replyRepository.findByCommentId(id);
		return replys;
	}	
}
