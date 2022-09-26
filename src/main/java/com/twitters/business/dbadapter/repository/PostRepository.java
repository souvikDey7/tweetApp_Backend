package com.twitters.business.dbadapter.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.twitters.business.dbadapter.dao.PostDao;

import be.twitter.customerdistribution.types.PostDetails;

public interface PostRepository extends MongoRepository<PostDao, String> {
	@Query(value = "{userId:'?0'}")
	List<PostDetails> findByUserId(String userId);

	@Query(value = "{userId:'?0'}")
	Page<PostDetails> findByUserId(String userId,Pageable page);
}
