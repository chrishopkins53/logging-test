package com.example.logginglistener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Slf4j
@RabbitListener(queues = "numberQueue")
public class WordReceiver {

    @RabbitHandler
    public void receive(String in) {
        System.out.println(" [x] Received '" + in + "'");
        log.info(" [x] Received '" + in + "'");

    }
}
