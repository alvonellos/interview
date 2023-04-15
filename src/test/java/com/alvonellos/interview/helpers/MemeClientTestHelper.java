package com.alvonellos.interview.helpers;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.fail;

public class MemeClientTestHelper {
    public static String getTopMemeExampleResponse() {
        Resource resource = new ClassPathResource("MemeClient/response/top_memes_response.html");

        String res = "";
        try(InputStreamReader input = new InputStreamReader(resource.getInputStream(), "UTF-8")) {
            BufferedReader reader = new BufferedReader(input);
            StringBuffer b = new StringBuffer();
            while (reader.ready()) {
                b.append(reader.readLine());
            }
            res = b.toString();
        } catch (Exception e) {
            return "";
        }
        return res;
    }
}
