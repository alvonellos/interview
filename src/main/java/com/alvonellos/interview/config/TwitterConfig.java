package com.alvonellos.interview.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@Configuration
@AllArgsConstructor
public class TwitterConfig {
    //AAAAAAAAAAAAAAAAAAAAAPEciQEAAAAAMoCm5lMmqnG2yvGDQw7FwTL69Bo%3DSFWTJqLRLLIgh1oUNJ9pUuF8Qj4OIRdWIOYwMvokTkD7Re9sHa
    //aUhjR3NHVnBGaUZuMlB4UnlKbHY6MTpjaQ
    //evL6kcNjyxvTb9vxKq-SvIxQd4zf59Dp35cjRdZLkIogDCX2LN
    @Bean
    public Twitter getTwitter() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("2UBNOsoiEwvU4UyKfZZBlNn5u")
                .setOAuthConsumerSecret("5BzqjVf58Mi3FFvc7yGRScrqMBFGGQueGFnXfCOrMcICpzDVwD")
                .setOAuthAccessToken("83694095-eCn8MdXUpPF7AYCGSZliTXKuqU7TvSB1eBr3FMwki")
                .setOAuthAccessTokenSecret("QjxHCdgj5YZ0IrBUI18QkSLiVPKVJR2KdqUD2iWvxdJGo");
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        return twitter;
    }
}
