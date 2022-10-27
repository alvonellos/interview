package com.alvonellos.interview.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Configuration
@Getter
public class ConfluentConfig {
    private static final String KAFKA_PROPERTIES_FILE = "kafka/kafka.config";
    private static final String TOPIC_NAME = "com.alvonellos.examples.store";
    private static final String TOPIC_PARTITIONS = "6";
    private static final String TOPIC_REPLICAS = "1";
    private Properties properties;

    {
        try {
            properties = loadConfig();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public final Properties loadConfig() throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(KAFKA_PROPERTIES_FILE);
        if (inputStream == null) {
            throw new IOException(KAFKA_PROPERTIES_FILE + " not found.");
        }
        final Properties cfg = new Properties();
        cfg.load(inputStream);
        return cfg;
    }
}
