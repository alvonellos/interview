package com.alvonellos.interview.config;

import com.alvonellos.interview.model.KVEntity;
import com.alvonellos.interview.repository.KVDatabase;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Configuration
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Log
public class FortuneConfig implements InitializingBean {
    public static final String FORTUNE_FILE = "fortune/fortune.txt";

    //Autowired in ctor
    private final KVDatabase database;

    /**
     * Runs after the bean has been initialized
     */
    @Override
    public void afterPropertiesSet() throws IOException {
    // fails if files have whitespaces or special characters, but this is only temporary
        URL resource = getClass().getClassLoader().getResource(FORTUNE_FILE);
        if (database.count() > 0) {
            log.info("Skipping initialization");
            return;
        }

        database.deleteAll();

        if (resource == null) {
            throw new IllegalArgumentException("file not found!");
        } else {
            // load the fortune files
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(FORTUNE_FILE);
            loadFortunes(inputStream);
        }
    }

    private int loadFortunes(InputStream stream) throws IOException {
        log.info("Loading fortune files...");

        String[] data = readFromInputStream(stream).split("%");

        List<KVEntity> fortunes = new ArrayList<>();
        for(String line : data) {
                fortunes.add(KVEntity.builder().KVEntityKey("FORTUNE").KVEntityValue(line).build());
               // log.info("Added fortune: " + line);
        }

        database.saveAll(fortunes);
        log.info("Loaded " + fortunes.size() + " fortunes");
        return 0;
    }

    private String readFromInputStream(InputStream inputStream)
            throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }
}
