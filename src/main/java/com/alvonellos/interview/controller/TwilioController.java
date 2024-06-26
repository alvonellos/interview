package com.alvonellos.interview.controller;

import com.alvonellos.interview.config.TwilioConfig;
import com.alvonellos.interview.service.TwitterService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.lookups.v1.PhoneNumber;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import twitter4j.TwitterException;

import java.util.Arrays;
import java.util.List;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TwilioController {
    private final TwilioConfig twilioConfig;


    @GetMapping("/twilio/carrier/{phone}")
    public ResponseEntity<String> getCarrier(@PathVariable(name = "phone") String phone) {
        Twilio.init(twilioConfig.accountSid, twilioConfig.authToken);
        PhoneNumber number = PhoneNumber
                .fetcher(new com.twilio.type.PhoneNumber(phone))
                .setCountryCode("US")
                .fetch();
        if(number.getCarrier() == null) {
            //actually this endpoint is pretty useless, because it doesn't return the carrier name
            //it returns null most of the time and the database seems to be out of date.
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(number.getCarrier().get("name").toString());
        }
    }

    @PostMapping("/twilio/sendMessage/{phone}")
    public ResponseEntity<String> sendMessage(@PathVariable(name = "phone") String phone, @RequestBody String message) {
        Twilio.init(twilioConfig.accountSid, twilioConfig.authToken);
        Message myMessage = Message.creator(
                new com.twilio.type.PhoneNumber(phone),
                twilioConfig.messagingServiceSid,
                message).create();
        return ResponseEntity.ok(myMessage.getSid());
    }
}
