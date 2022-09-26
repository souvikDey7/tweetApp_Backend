package com.twitters.business.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class KafkaProducer {
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendMessage(String message) {
		
		log.info(String.format("Message sent-> %s", message));
		kafkaTemplate.send("tweet-application", message);
	}

}