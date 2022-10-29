package com.alvonellos.interview.service;

import com.alvonellos.interview.config.KafkaConsumerConfig;
import com.alvonellos.interview.config.KafkaProducerConfig;
import com.alvonellos.interview.config.KafkaTopicConfig;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Log
public class KafkaService implements InitializingBean {

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

    /**
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        log.entering(this.getClass().getName(), "afterPropertiesSet");
        Runnable r = new Runnable() {
            @Override
            public void run() {
                log.entering(this.getClass().getName(), "run");
                while(true) {
                    send("Hello World");
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread t = new Thread(r);
        t.start();
        log.exiting(this.getClass().getName(), "afterPropertiesSet");

    }
}
