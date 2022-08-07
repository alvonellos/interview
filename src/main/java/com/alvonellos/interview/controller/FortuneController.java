package com.alvonellos.interview.controller;

import com.alvonellos.interview.repository.KVDatabase;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class FortuneController {
    //autowire the database connection
    private final KVDatabase database;

    //get mapping for the database
    @GetMapping("/fortune")
    public String getFortune() {
        return database.getRandomValue("FORTUNE");
    }
}
