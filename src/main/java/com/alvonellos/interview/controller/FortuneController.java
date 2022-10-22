package com.alvonellos.interview.controller;

import com.alvonellos.interview.client.KanyeClient;
import com.alvonellos.interview.model.KVEntity;
import com.alvonellos.interview.model.client.KanyeQuote;
import com.alvonellos.interview.repository.KVDatabase;
import com.alvonellos.interview.service.KVService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.alvonellos.interview.util.numbers.NumberManipulation.randBetween;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Log
public class FortuneController {
    //autowire the database connection
    private final KVDatabase database;
    private final KanyeClient kanyeClient;


    //get mapping for the database
    @GetMapping("/fortune")
    public ResponseEntity<String> getFortune() {
        Optional<KVEntity> fortune = database.findById(randBetween(1L, database.count()));
        while(fortune == null || !fortune.get().getKVEntityKey().equals("FORTUNE")) {
            log.info("Searching for fortune...");
            fortune = database.findById(randBetween(1L, database.count()));
        }

        if (fortune.isPresent()) {
            return ResponseEntity.ok(fortune.get().toString());
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/kanyeQuotes/{numTimes}")
    public ResponseEntity<String> getKanyeQuotes(@PathVariable("numTimes") int numTimes) {
        List<KanyeQuote> quote = kanyeClient.getKanyeQuote(numTimes);

        Runnable r = () -> {
            quote.parallelStream().forEach(kanyeQuote -> {
                database.save(new KVEntity("kanyeQuote", kanyeQuote.getQuote()));
            });
        };

        r.run();

        return ResponseEntity.ok("job started");
    }
}
