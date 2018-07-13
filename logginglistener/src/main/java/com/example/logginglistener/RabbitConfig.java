package com.example.logginglistener;

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
    public WordReceiver receiver() {
        return new WordReceiver();
    }

}
