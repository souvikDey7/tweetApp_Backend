package com.twitters.business.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.twitters.business.dbadapter.dao.PostDao;

import be.twitter.customerdistribution.types.PostDetails;

@Mapper(componentModel = "spring")
public interface SearchMapper {
	
	List<PostDetails> toPostDetails(List<PostDao> post);
}
