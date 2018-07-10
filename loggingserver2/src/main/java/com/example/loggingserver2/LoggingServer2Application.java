package com.example.loggingserver2;

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
public class LoggingServer2Application {


    @GetMapping(value = "/{number}", produces = APPLICATION_JSON_VALUE)
    public String getNumber(@PathVariable int number) {
        log.info("Received number " + number);

        return makeNumberString(number);

    }


    public static void main(String[] args) {
        SpringApplication.run(LoggingServer2Application.class, args);
        log.debug("Starting server");
    }

    private String makeNumberString(int number) {

        switch (number) {

            case 4:
                return "four";

            case 5:
                return "five";

            case 6:
                return "six";

            default:
                log.error("Invalid number");
                throw new IllegalArgumentException("Number " + number + " is out of range");

        }
    }
}
