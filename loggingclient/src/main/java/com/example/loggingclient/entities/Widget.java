package com.example.loggingclient.entities;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class Widget {

    public void doSomething() {
        log.info("Widget doing something");
        System.out.println("Widget doing something");
    }

}
