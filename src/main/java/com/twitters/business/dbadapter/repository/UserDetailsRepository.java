package com.twitters.business.dbadapter.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.twitters.business.dbadapter.dao.UserDetailsDao;

public interface UserDetailsRepository extends MongoRepository<UserDetailsDao, String> {
	@Query(value = "{userId:{$regex:/?0/}}")
	List<UserDetailsDao> findUserName(String name);
	
	@Query(value = "{userId:{$regex:/?0/}}")
	Page<UserDetailsDao> findUserName(String name,Pageable page);
}
