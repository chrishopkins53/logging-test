package com.example.loggingserver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@SpringBootApplication
@RestController
public class LoggingServerApplication {

    @GetMapping(value = "/{number}", produces = APPLICATION_JSON_VALUE)
    public String getNumber(@PathVariable int number) {
        log.info("Received number " + number);
        return String.valueOf(number);

        //todo: make some rules about the number and throw exception if broken
    }


    public static void main(String[] args) {
        SpringApplication.run(LoggingServerApplication.class, args);
        log.debug("Starting server");
    }
}
