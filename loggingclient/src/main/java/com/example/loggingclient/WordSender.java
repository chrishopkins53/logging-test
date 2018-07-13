package com.example.loggingclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class WordSender {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue;

    public void send(String number){
        this.template.convertAndSend(queue.getName(), number);
        log.info("Sending " + number);
    }

}
