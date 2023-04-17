package com.alvonellos.interview.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
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

