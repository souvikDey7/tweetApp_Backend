package com.twitters.business.dbadapter.service;

import com.twitters.business.model.CredentialDTO;
import com.twitters.business.model.UserDetailsDTO;

public interface RegisterDBservice {

	String setUserRegistration(UserDetailsDTO userDetailsDTO);

	String userLogin(CredentialDTO credentialDTO);
	
	String resetPassword(String username);
}
