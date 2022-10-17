package com.alvonellos.interview.service;

import com.alvonellos.interview.model.KVEntity;
import com.alvonellos.interview.repository.KVDatabase;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.util.Optional;

import static com.alvonellos.interview.util.numbers.NumberManipulation.randBetween;

@Service
@Log
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TwitterService implements InitializingBean {

    private final Twitter twitter;
    private final KVDatabase database;

    public Twitter getTwitter() {
        return twitter;
    }

    public String postFortune() throws TwitterException {
        Optional<KVEntity> fortune = database.findById(randBetween(1L, database.count()));
        if (fortune.isPresent()) {
            String message = fortune.get().getKVEntityValue().toString();
            return twitter.updateStatus(message).getCreatedAt().toString();
        } else {
           throw new TwitterException("Failed to post message");
        }
    }


    @Override
    public void afterPropertiesSet() throws Exception {
    }
}
