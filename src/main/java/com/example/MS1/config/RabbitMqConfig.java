package com.example.MS1.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

 
 
@Configuration
public class RabbitMqConfig {

    @Value("${rabbitMq.queue.name}")
    private String queueName;

    @Value("${rabbitMq.exchange.name}")
    private String exchangeName;
    
    @Value("${rabbitMq.key.name}")
    private String keyName;

    @Bean
    public Queue queue() {
        return new Queue(queueName);
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(exchangeName);  
    }

    @Bean
    public Binding binding() {
        return BindingBuilder
                .bind(queue())
                .to(exchange())      
                .with(keyName);        
    }
}
