package com.alvonellos.interview.service;

import com.alvonellos.interview.config.KafkaConsumerConfig;
import com.alvonellos.interview.config.KafkaProducerConfig;
import com.alvonellos.interview.config.KafkaTopicConfig;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Log
public class KafkaService {

    private final KafkaTopicConfig kafkaTopicConfig;
    private final KafkaTemplate kafkaTemplate;

        public void send(String message) {
            log.entering(this.getClass().getName(), "send", message);
            kafkaTemplate.send(kafkaTopicConfig.topic1().name(), message);
            log.exiting(this.getClass().getName(), "send");
        }

        @KafkaListener(topics = "com.alvonellos.interview", groupId = KafkaConsumerConfig.GROUP_ID)
        public void receive(String message) {
            log.entering(this.getClass().getName(), "receive", message);
            log.info("Received message: " + message);
            log.exiting(this.getClass().getName(), "receive");
        }
}
