package com.alvonellos.interview.controller;

import com.alvonellos.interview.config.ConfluentConfig;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Properties;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class StoreController {
    private final ConfluentConfig confluentConfig;

    @GetMapping("/store/properties")
    public ResponseEntity<Properties> getProperties() throws IOException {
        Properties properties = confluentConfig.loadConfig();
        return new ResponseEntity<>(properties, HttpStatus.OK);
    }

    @GetMapping("/store/kafkaHealth")
    public ResponseEntity<String> kafkaHealth() throws IOException {
        Properties properties = confluentConfig.loadConfig();
        KafkaConsumer kafkaConsumer = new KafkaConsumer(properties);
        KafkaProducer kafkaProducer = new KafkaProducer(properties);
        return new ResponseEntity<>("Kafka is healthy", HttpStatus.OK);
        //todo:fix this
    }

//
//    @GetMapping("/health")
//    public ResponseEntity<String> health() {
//
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
