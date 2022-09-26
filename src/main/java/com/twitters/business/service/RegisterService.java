package com.twitters.business.service;

import com.twitters.business.model.CredentialDTO;
import com.twitters.business.model.UserDetailsDTO;

public interface RegisterService {
	String userRegistration(UserDetailsDTO userDetailsDTO);

	String userLogin(CredentialDTO CredentialDTO);

	String resetPassword(String username);
}