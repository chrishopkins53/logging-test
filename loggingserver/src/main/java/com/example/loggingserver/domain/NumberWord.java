package com.example.loggingserver.domain;

import lombok.Data;

import javax.persistence.Entity;


@Data
@Entity
public class NumberWord {

    private String id;
    private String word;

    public NumberWord(String numberWord){
        this.word = numberWord;
    }
}


