package com.alvonellos.interview.config;

import com.alvonellos.interview.model.KVEntity;
import com.alvonellos.interview.repository.KVDatabase;
import com.maxmind.geoip2.DatabaseReader;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Configuration
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Log
public class MaxMindConfig {
    public static final String IPDB_FILE = "ipdb/GeoLite2-City.mmdb";

    @Bean
    public DatabaseReader databaseReader() throws IOException {
        URL resource = getClass().getClassLoader().getResource(IPDB_FILE);
        if (resource == null) {
            throw new IllegalArgumentException("file not found!");
        } else {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(IPDB_FILE);
            return new DatabaseReader.Builder(inputStream).build();
        }
    }
    /**
     * Runs after the bean has been initialized
     */
}
