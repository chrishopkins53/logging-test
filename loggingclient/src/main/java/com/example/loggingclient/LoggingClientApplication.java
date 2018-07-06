package com.example.loggingclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class LoggingClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoggingClientApplication.class, args);
        log.debug("Starting client");
    }


}
