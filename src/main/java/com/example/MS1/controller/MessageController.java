package com.example.MS1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.MS1.producer.RMQproducer;

@RestController
@RequestMapping("/api")
public class MessageController {
	
	@Autowired
	public RMQproducer qproducer;
	
	@GetMapping("/publish")
	public ResponseEntity<?>sendMessage(@RequestParam String message)
	{
		qproducer.sendMessage("hello from rabbitmq restApi");
		return ResponseEntity.ok("success");
	}
	

}
