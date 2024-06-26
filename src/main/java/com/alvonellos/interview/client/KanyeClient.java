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
import java.util.ArrayList;
import java.util.List;

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
        } catch (Exception e) {
            log.info("Error while getting kanye quote from " + kanyeClientURLProp.getBaseUrl());
            return null;
        }
    }

    public List<KanyeQuote> getKanyeQuote(final int numTimes){
        KanyeClientURL kanyeClientURLProp = properties.getKanyeClientURL();
        List<KanyeQuote> kanyeQuotes = new ArrayList<>(numTimes);

        URI url =
                UriComponentsBuilder.newInstance()
                        .scheme(kanyeClientURLProp.getScheme())
                        .host(kanyeClientURLProp.getBaseUrl())
                        .pathSegment(kanyeClientURLProp.getResourcePath())
                        .build()
                        .toUri();
            List<KanyeQuote> response = new ArrayList<>();
        for (int i = 0; i < numTimes; i++) {
            try {
                KanyeQuote quote = restTemplate.exchange(url, HttpMethod.GET, null, KanyeQuote.class).getBody();
                response.add(quote);
            } catch (RestClientException e) {
                log.info("Error while getting kanye quote from " + kanyeClientURLProp.getBaseUrl());
            }
        }
        log.info("Got kanye quote: " + response);
        return response;
    }
}
