package com.example.loggingclient;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {

    private RestTemplate restTemplate;

    public ApiService(RestTemplateBuilder builder) {

        this.restTemplate = builder.build();

    }

    public String getStringNumber(String number) {
        return restTemplate.getForObject("http://localhost:8090/" + number, String.class);
    }
}
