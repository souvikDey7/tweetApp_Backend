package com.twitters.business.config;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;


@Component
public class KafkaConsumer {
	
	@KafkaListener(topics = "tweet-application")
	public void consumeMessage(Message<String> message) {
		System.out.println(String.format("Message received -> %s", message.getPayload()));
	}
}