package com.alvonellos.interview.config;

import lombok.extern.java.Log;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.net.URL;

@Configuration
@Log
public class FortuneConfig implements InitializingBean {
    public static final String FORTUNE_FILE = "fortune/fortune.txt";

    /**
     * Runs after the bean has been initialized
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        URL resource = getClass().getClassLoader().getResource(FORTUNE_FILE);
        if (resource == null) {
            throw new IllegalArgumentException("file not found!");
        } else {

            // failed if files have whitespaces or special characters
            System.err.println(new File(resource.getFile()).toPath());
        }
    }
}
