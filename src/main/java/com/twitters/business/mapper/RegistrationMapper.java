package com.twitters.business.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

import com.twitters.business.dbadapter.dao.CredentialDao;
import com.twitters.business.dbadapter.dao.UserDetailsDao;
import com.twitters.business.model.CredentialDTO;
import com.twitters.business.model.UserDetailsDTO;

import be.twitter.customerdistribution.types.Credential;
import be.twitter.customerdistribution.types.PostDetails;
import be.twitter.customerdistribution.types.User;
import be.twitter.customerdistribution.types.UserDetails;

@Mapper(componentModel = "spring")
public interface RegistrationMapper {

	public UserDetailsDTO toUserDetailsDTO(UserDetails userDetails);

	public CredentialDTO toCredentialDTO(Credential credential);

	@Mapping(target = "userId", source = "userDetailsDTO.cridential.loginId")
	public UserDetailsDao toUserDetailsDao(UserDetailsDTO userDetailsDTO);

	public User toUser(UserDetailsDao userDetailsDao);
	
	@Mapping(target = "userId", source = "userDetailsDTO.cridential.loginId")
	@Mapping(target = "password", source = "userDetailsDTO.cridential.password")
	public CredentialDao userDetailsDTOtoCredentialDao(UserDetailsDTO userDetailsDTO);
	
	public List<PostDetails> toUserPostList(Page<PostDetails> tweets);

}