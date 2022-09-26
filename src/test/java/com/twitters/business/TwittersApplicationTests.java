package com.twitters.business;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration()
class TwittersApplicationTests {

	@InjectMocks
	private TwittersApplication s;

	@Before
	public void setup() {
		s = new TwittersApplication();
	}

	@Test
	void contextLoads() {
		assertTrue(true);
	}

}
