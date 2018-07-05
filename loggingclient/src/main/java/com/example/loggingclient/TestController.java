package com.example.loggingclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@Slf4j
@RestController
public class TestController {

    private ApiService apiService;

    public TestController(ApiService apiService) {
        this.apiService = apiService;
    }

    @RequestMapping("/")
    public String home() {
        log.info("Handling home");

        Random r = new Random();

        String requestNumber = String.valueOf(r.nextInt(12));  // random int 0..11

        log.info("Requesting number " + requestNumber);

        try {
            String result = apiService.getStringNumber(requestNumber);
            return "Returned number: " + result;
        } catch (Exception e){

            log.error("Number api failed", e);

            return null;
        }


        //Widget widget = new Widget();
        //widget.doSomething();


        //todo: pick a random number, call the other service, return the response
    }


}
