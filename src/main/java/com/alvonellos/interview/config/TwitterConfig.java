package com.alvonellos.interview.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@Configuration
@AllArgsConstructor
public class TwitterConfig {

    public Twitter getTwitter() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("your consumer key")
                .setOAuthConsumerSecret("your consumer secret")
                .setOAuthAccessToken("your access token")
                .setOAuthAccessTokenSecret("your access token secret");
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        return twitter;
    }
}
