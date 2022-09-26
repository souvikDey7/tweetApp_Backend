package com.twitters.business.dbadapter.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.twitters.business.dbadapter.dao.ReplyDao;

import be.twitter.customerdistribution.types.ReplyDetails;

public interface ReplyRepository extends MongoRepository<ReplyDao, String> {

	@Query(value = "{commentId:'?0'}")
	List<ReplyDetails> findByCommentId(String commentId);
}
