package com.example.loggingclient;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public Queue numberQueue() {
        return new Queue("numberQueue");

    }

    @Bean
    public WordSender sender() {
        return new WordSender();
    }

}
