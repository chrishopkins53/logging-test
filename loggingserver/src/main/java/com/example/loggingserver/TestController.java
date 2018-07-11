package com.example.loggingserver;

import com.example.loggingserver.domain.NumberWord;
import com.example.loggingserver.repositories.WordRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
public class TestController {

    private ApiService apiService;
    private final WordRepository wordRepository;

    public TestController(ApiService apiService, WordRepository wordRepository) {
        this.apiService = apiService;
        this.wordRepository = wordRepository;
    }

    @GetMapping(value = "/{number}", produces = APPLICATION_JSON_VALUE)
    public String getNumber(@PathVariable int number) throws IllegalArgumentException {
        log.info("Received number " + number);

        NumberWord responseWord = new NumberWord(getNumberString(number));

        wordRepository.save(responseWord);

        return responseWord.getWord();
    }


    private String getNumberString(int number) {

        switch (number) {

            case 1:
            case 2:
            case 3:
                return makeNumberString(number);

            case 4:
            case 5:
            case 6:
                return apiService.getStringNumber2(number);

            case 7:
            case 8:
            case 9:
            case 10:
                return apiService.getStringNumber3(number);

            default:
                log.error("Invalid number");
                throw new IllegalArgumentException("Number " + number + " is out of range");

        }
    }

    private String makeNumberString(int number) {

        switch (number) {

            case 1:
                return "one";

            case 2:
                return "two";

            case 3:
                return "three";

            default:
                log.error("Invalid number");
                throw new IllegalArgumentException("Number " + number + " is out of range");

        }
    }
}
