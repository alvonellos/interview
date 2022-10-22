package com.alvonellos.interview.config;

import com.alvonellos.interview.exceptions.InterviewAPIException;
import com.twilio.Twilio;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@Configuration
@Log
public class TwilioConfig implements InitializingBean  {
    @Value("${interview.client.twilio.account-sid}")
    public String accountSid;

    @Value("${interview.client.twilio.auth-token}")
    public String authToken;

    @Value("${interview.client.twilio.messaging-service-sid}")
    public String messagingServiceSid;

    @Value("${interview.client.twilio.phone-number}")
    public String phoneNumber;


    @Override
    public void afterPropertiesSet() throws Exception {
        if(accountSid == null || authToken == null) {
            throw new InterviewAPIException("Twilio accountSid and authToken must be set") {
                @Override
                public String getMessage() {
                    return super.getMessage();
                }
            };
        }

        log.config("Twilio account sid: " + accountSid);
        log.config("Twilio auth token: " + authToken);
    }
}
