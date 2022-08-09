package com.alvonellos.interview.controller;

import com.alvonellos.interview.model.KVEntity;
import com.alvonellos.interview.repository.KVDatabase;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static com.alvonellos.interview.util.numbers.NumberManipulation.randBetween;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class FortuneController {
    //autowire the database connection
    private final KVDatabase database;

    //get mapping for the database
    @GetMapping("/fortune")
    public ResponseEntity<String> getFortune() {
        Optional<KVEntity> fortune = database.findById(randBetween(1L, database.count()));
        if (fortune.isPresent()) {
            return ResponseEntity.ok(fortune.get().toString());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
