package com.alvonellos.interview.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CaptionImageResponseDTO {
    @JsonProperty("success")
    private boolean success;

    @JsonProperty("data")
    private CaptionImageResponseData data;

    @JsonProperty("error_message")
    private String errorMessage;

    @Data
    public static class CaptionImageResponseData {
        @JsonProperty("url")
        private String url;

        @JsonProperty("page_url")
        private String pageUrl;
    }
}

