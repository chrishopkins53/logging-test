package com.example.loggingserver.repositories;

import com.example.loggingserver.domain.NumberWord;
import org.springframework.data.repository.CrudRepository;

public interface WordRepository extends CrudRepository<NumberWord, String> {
}
