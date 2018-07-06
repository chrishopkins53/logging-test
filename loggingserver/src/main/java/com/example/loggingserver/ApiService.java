package com.example.loggingserver;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {

    private RestTemplate restTemplate;

    public ApiService(RestTemplateBuilder builder) {

        this.restTemplate = builder.build();

    }

    public String getStringNumber2(int number) {
        return restTemplate.getForObject("http://localhost:8092/" + number, String.class);
    }

    public String getStringNumber3(int number) {
        return restTemplate.getForObject("http://localhost:8093/" + number, String.class);
    }
}
