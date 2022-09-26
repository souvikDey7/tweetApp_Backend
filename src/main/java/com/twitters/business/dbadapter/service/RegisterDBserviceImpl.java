package com.twitters.business.dbadapter.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twitters.business.dbadapter.dao.CredentialDao;
import com.twitters.business.dbadapter.repository.CredentialRepository;
import com.twitters.business.dbadapter.repository.UserDetailsRepository;
import com.twitters.business.mapper.RegistrationMapper;
import com.twitters.business.model.CredentialDTO;
import com.twitters.business.model.UserDetailsDTO;

@Service
public class RegisterDBserviceImpl implements RegisterDBservice {

	@Autowired
	RegistrationMapper registrationMapper;

	@Autowired
	private CredentialRepository credentialRepository;
	@Autowired
	private UserDetailsRepository userDetailsRepository;

	@Override
	public String setUserRegistration(UserDetailsDTO userDetailsDTO) {
		try {
			if (userDetailsRepository.existsById(userDetailsDTO.getCridential().getLoginId()))
				return "duplicate entry";
			userDetailsRepository.save(registrationMapper.toUserDetailsDao(userDetailsDTO));
			credentialRepository.save(registrationMapper.userDetailsDTOtoCredentialDao(userDetailsDTO));
			return "success";

		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public String userLogin(CredentialDTO credentialDTO) {
		try {
			if (!credentialRepository.existsById(credentialDTO.getLoginId()))
				return "not exist";
			Optional<CredentialDao> credentialDao = credentialRepository.findById(credentialDTO.getLoginId());
			if (credentialDao.get().getPassword().equals(credentialDTO.getPassword()))
				return "success";
			return "wrong credential";
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public String resetPassword(String username) {
		if (!credentialRepository.existsById(username))
			return "not exist";

		return "set new password";
	}
}
