package com.example.loggingclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.sleuth.SpanName;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
public class TestController {

    private ApiService apiService;

    public TestController(ApiService apiService) {
        this.apiService = apiService;
    }

    @RequestMapping("/")
    public String random() {
        log.info("Handling random");

        Random r = new Random();

        String requestNumber = String.valueOf(r.nextInt(12));  // random int 0..11

        log.info("Requesting number " + requestNumber);

        return getStringNumber(requestNumber);

    }

    @GetMapping(value = "/{number}", produces = APPLICATION_JSON_VALUE)
    public String getNumber(@PathVariable int number) {

        String requestNumber = String.valueOf(number);

        log.info("Requesting number " + requestNumber);

        return getStringNumber(requestNumber);


    }

    private String getStringNumber(String requestNumber) {
        try {
            String result = apiService.getStringNumber(requestNumber);
            return "Returned number: " + result;
        } catch (Exception e){

            log.error("Number api failed", e);

            return "Bad number";
        }
    }

}
