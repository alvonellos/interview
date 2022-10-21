package com.alvonellos.interview.controller;

import com.alvonellos.interview.client.KanyeClient;
import com.alvonellos.interview.model.KVEntity;
import com.alvonellos.interview.model.client.KanyeQuote;
import com.alvonellos.interview.repository.KVDatabase;
import com.alvonellos.interview.service.TwitterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import twitter4j.TwitterException;

import java.util.List;
import java.util.Optional;

import static com.alvonellos.interview.util.numbers.NumberManipulation.randBetween;
import static org.apache.naming.SelectorContext.prefix;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TwitterController {
    //autowire the service layer connection
    private final TwitterService twitterService;

    //get mapping for the database
    @PostMapping("/twitter/fortune")
    public ResponseEntity<String> getFortune() throws TwitterException {
        return ResponseEntity.ok(this.twitterService.postFortune());
    }

    @GetMapping("/twitter/fortune")
    public ResponseEntity<List<String>> getFortunes() throws TwitterException {
        return ResponseEntity.ok(this.twitterService.getFortunes());
    }
}
