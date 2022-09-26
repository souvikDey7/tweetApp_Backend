package com.twitters.business.dbadapter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.twitters.business.dbadapter.dao.CredentialDao;

public interface CredentialRepository extends MongoRepository<CredentialDao, String> {

}
