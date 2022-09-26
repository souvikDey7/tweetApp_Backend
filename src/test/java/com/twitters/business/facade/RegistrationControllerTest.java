package com.twitters.business.facade;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.twitters.business.mapper.RegistrationMapper;
import com.twitters.business.model.UserDetailsDTO;
import com.twitters.business.security.JwtUtils;
import com.twitters.business.service.RegisterService;

import be.twitter.customerdistribution.types.Credential;
import be.twitter.customerdistribution.types.UserDetails;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationControllerTest {

	@InjectMocks
	private RegistrationController registrationController;

	@Mock
	private RegisterService registerService;

	@Mock
	private RegistrationMapper registrationMapper;

	@Autowired
	private JwtUtils jwt;

	@Test
	public void testUserRegistration() {
	}
}