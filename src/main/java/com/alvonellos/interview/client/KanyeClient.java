package com.alvonellos.interview.client;

import com.alvonellos.interview.config.KanyeClientURL;
import com.alvonellos.interview.model.client.KanyeQuote;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
@Log
public class KanyeClient {
    private final RestTemplate restTemplate;
    private final ClientProperties properties;

    @Autowired
    public KanyeClient(RestTemplate restTemplate, ClientProperties properties) {
        this.restTemplate = restTemplate;
        this.properties = properties;
    }

    public String getKanyeQuote() {
        final KanyeClientURL kanyeClientURLProp = properties.getKanyeClientURL();

        URI url =
                UriComponentsBuilder.newInstance()
                        .scheme(kanyeClientURLProp.getScheme())
                        .host(kanyeClientURLProp.getBaseUrl())
                        .pathSegment(kanyeClientURLProp.getResourcePath())
                        .build()
                        .toUri();

        log.info("Getting kanye quote from " + kanyeClientURLProp.getBaseUrl());
        try {
            KanyeQuote response = restTemplate.exchange(url, HttpMethod.GET, null, KanyeQuote.class).getBody();
            log.info("Got kanye quote: " + response);
            return response.getQuote();
        } catch (RestClientException e) {
            log.info("Error while getting kanye quote from " + kanyeClientURLProp.getBaseUrl());
            throw e;
        }
    }

}
