package com.example.MS1.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RMQconsumer {

	@RabbitListener(queues = {"${rabbitMq.queue.name}"})
	public void Consume(String message)
	{
		System.out.println("message--->"+message);
		
	}
}
