package com.twitters.business.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twitters.business.dbadapter.service.RegisterDBservice;
import com.twitters.business.model.CredentialDTO;
import com.twitters.business.model.UserDetailsDTO;

@Service
public class RegisterServiceImpl implements RegisterService {

	Logger logger = LoggerFactory.getLogger(RegisterServiceImpl.class);

	@Autowired
	private RegisterDBservice registerDBservice;

	@Override
	public String userRegistration(UserDetailsDTO userDetailsDTO) {
		return registerDBservice.setUserRegistration(userDetailsDTO);
	}

	@Override
	public String userLogin(CredentialDTO CredentialDTO) {
		logger.debug("in userlogin");
		return registerDBservice.userLogin(CredentialDTO);
	}

	@Override
	public String resetPassword(String username) {
		return registerDBservice.resetPassword(username);
	}
}
