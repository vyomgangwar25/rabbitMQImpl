package com.example.MS1.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RMQproducer {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Value("${rabbitMq.exchange.name}")
	private String exchangeName;

	@Value("${rabbitMq.key.name}")
	private String keyName;
//
//	String message = "hello world!!";

	public void sendMessage(String message) {
		rabbitTemplate.convertAndSend(exchangeName, keyName, message);
	}

}
