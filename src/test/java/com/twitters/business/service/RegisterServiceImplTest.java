package com.twitters.business.service;

import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.twitters.business.dbadapter.service.RegisterDBservice;
import com.twitters.business.model.UserDetailsDTO;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RegisterServiceImplTest {

	@InjectMocks
	private RegisterServiceImpl registerServiceImpl;

	@Mock
	private RegisterDBservice registerDBservice;

	@Test
	public void testUserRegistration() throws Exception {
	}

}