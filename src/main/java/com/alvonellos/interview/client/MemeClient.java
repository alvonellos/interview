package com.alvonellos.interview.client;


import com.alvonellos.interview.config.MemeClientURL;
import com.alvonellos.interview.dto.MemeTemplateDTO;
import com.alvonellos.interview.dto.response.AiMemeResponseDTO;
import com.alvonellos.interview.dto.response.CaptionImageResponseDTO;
import com.alvonellos.interview.dto.response.MemeResponseDTO;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service
@Log
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MemeClient {
    private final RestTemplate restTemplate;

    private final ClientProperties properties;

    public MemeResponseDTO getMemes() {
        final MemeClientURL memeClientURLProp = properties.getMemeClientURL();

        URI url =
                UriComponentsBuilder.newInstance()
                        .scheme(memeClientURLProp.getScheme())
                        .host(memeClientURLProp.getBaseUrl())
                        .pathSegment(memeClientURLProp.getGetMemesPath())
                        .build()
                        .toUri();

        log.info("Getting memes from " + memeClientURLProp.getBaseUrl());
        try {
            MemeResponseDTO response = restTemplate.exchange(url, HttpMethod.GET, null, MemeResponseDTO.class).getBody();
            log.info("Got memes: " + response);
            return response;
        } catch (Exception e) {
            log.info("Error while getting memes from " + memeClientURLProp.getBaseUrl());
            return null;
        }
    }

    public CaptionImageResponseDTO createMeme(String templateId, String text0, String text1) {
        final MemeClientURL memeClientURLProp = properties.getMemeClientURL();

        // build URL for meme creation endpoint
        URI url = UriComponentsBuilder.newInstance()
                .scheme(memeClientURLProp.getScheme())
                .host(memeClientURLProp.getBaseUrl())
                .pathSegment(memeClientURLProp.getCaptionImagePath())
                .build()
                .toUri();

        // create request body with template ID and caption text
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("template_id", templateId);
        requestBody.add("username", memeClientURLProp.getEmail());
        requestBody.add("password", memeClientURLProp.getPassword());
        requestBody.add("text0", text0);
        requestBody.add("text1", text1);

        // create HTTP headers with content type application/x-www-form-urlencoded
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        // create HTTP entity with request body and headers
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(requestBody, headers);

        // send POST request and get response
        log.info("Creating meme using template ID " + templateId);
        try {
            CaptionImageResponseDTO response = restTemplate.exchange(url, HttpMethod.POST, entity, CaptionImageResponseDTO.class).getBody();
            log.info("Created meme with URL " + response.isSuccess());
            return response;
        } catch (Exception e) {
            log.info("Error while creating meme using template ID " + templateId);
            return null;
        }
    }

    public MemeResponseDTO searchMeme(String query, Boolean includeNsfw) {
        final MemeClientURL memeClientURLProp = properties.getMemeClientURL();

        // build URL for meme creation endpoint
        URI url = UriComponentsBuilder.newInstance()
                .scheme(memeClientURLProp.getScheme())
                .host(memeClientURLProp.getBaseUrl())
                .pathSegment(memeClientURLProp.getSearchMemesPath())
                .build()
                .toUri();

        // create request body with template ID and caption text
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("username", memeClientURLProp.getEmail());
        requestBody.add("password", memeClientURLProp.getPassword());
        requestBody.add("query", query);
        requestBody.add("include_nsfw", includeNsfw.toString());

        // create HTTP headers with content type application/x-www-form-urlencoded
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        // create HTTP entity with request body and headers
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(requestBody, headers);

        // send POST request and get response
        log.info("Searching meme using query");
        try {
            MemeResponseDTO response = restTemplate.exchange(url, HttpMethod.POST, entity, MemeResponseDTO.class).getBody();
            log.info("Searched memes with URL " + response.isSuccess());
            return response;
        } catch (Exception e) {
            log.info("Error while searching for memes");
            return null;
        }
    }

    public CaptionImageResponseDTO autoMeme(String text, Boolean removeWaterMark) {
        final MemeClientURL memeClientURLProp = properties.getMemeClientURL();

        // build URL for meme creation endpoint
        URI url = UriComponentsBuilder.newInstance()
                .scheme(memeClientURLProp.getScheme())
                .host(memeClientURLProp.getBaseUrl())
                .pathSegment(memeClientURLProp.getAutoMemePath())
                .build()
                .toUri();

        // create request body with template ID and caption text
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("username", memeClientURLProp.getEmail());
        requestBody.add("password", memeClientURLProp.getPassword());
        requestBody.add("text", text);
        requestBody.add("no_watermark", removeWaterMark.toString());

        // create HTTP headers with content type application/x-www-form-urlencoded
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        // create HTTP entity with request body and headers
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(requestBody, headers);

        // send POST request and get response
        log.info("Automeme meme using text");
        try {
            CaptionImageResponseDTO response = restTemplate.exchange(url, HttpMethod.POST, entity, CaptionImageResponseDTO.class).getBody();
            log.info("Automeme memes with URL " + response.isSuccess());
            return response;
        } catch (Exception e) {
            log.info("Error while automeming");
            return null;
        }
    }

    public AiMemeResponseDTO aiMeme(Boolean removeWaterMark) {
        final MemeClientURL memeClientURLProp = properties.getMemeClientURL();

        // build URL for meme creation endpoint
        URI url = UriComponentsBuilder.newInstance()
                .scheme(memeClientURLProp.getScheme())
                .host(memeClientURLProp.getBaseUrl())
                .pathSegment(memeClientURLProp.getAiMemePath())
                .build()
                .toUri();

        // create request body with template ID and caption text
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("username", memeClientURLProp.getEmail());
        requestBody.add("password", memeClientURLProp.getPassword());
        //requestBody.add("template_id", templateId);
        requestBody.add("no_watermark", removeWaterMark.toString());

        // create HTTP headers with content type application/x-www-form-urlencoded
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        // create HTTP entity with request body and headers
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(requestBody, headers);

        // send POST request and get response
        log.info("Aimeme meme using text");
        try {
            AiMemeResponseDTO response = restTemplate.exchange(url, HttpMethod.POST, entity, AiMemeResponseDTO.class).getBody();
            log.info("Aimeme memes with URL " + response.isSuccess());
            return response;
        } catch (Exception e) {
            log.info("Error while Aimeme");
            return null;
        }
    }

    public List<MemeTemplateDTO> getTopMemes() {
        final MemeClientURL memeClientURLProp = properties.getMemeClientURL();

        URI url =
                UriComponentsBuilder.newInstance()
                        .scheme(memeClientURLProp.getScheme())
                        .host(memeClientURLProp.getBaseUrl())
                        .pathSegment(memeClientURLProp.getGetTopPath())
                        .build()
                        .toUri();

        String htmlResponse = restTemplate.getForObject(url, String.class); // make GET request to endpoint URL

        return parseHtmlPage(htmlResponse);

    }

    List<MemeTemplateDTO> parseHtmlPage(String htmlResponse) {
        Document doc = Jsoup.parse(htmlResponse); // parse HTML response with Jsoup

        // select table element with class "admin-table"
        Element table = doc.selectFirst("table.admin-table");

        // parse table rows and columns
        List<MemeTemplateDTO> dtos = new ArrayList<>();
        Elements rows = table.select("tr");
        for (Element row : rows) {
            Elements columns = row.select("td");
            if (columns.size() >= 3) { // check if row has at least 3 columns
                Long id = Long.parseLong(columns.get(0).text());
                String name = columns.get(1).text();
                String alternateNames = columns.get(2).text();
                dtos.add(new MemeTemplateDTO(id, name, alternateNames));
            }
        }
        return dtos;
    }
}
