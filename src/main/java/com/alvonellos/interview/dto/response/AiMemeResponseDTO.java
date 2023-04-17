package com.alvonellos.interview.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AiMemeResponseDTO {
    @JsonProperty("success")
    private boolean success;

    @JsonProperty("data")
    private AiMemeResponseData data;

    @JsonProperty("error_message")
    private String errorMessage;

    @Data
    public static class AiMemeResponseData {
        @JsonProperty("url")
        private String url;

        @JsonProperty("page_url")
        private String pageUrl;

        @JsonProperty("template_id")
        private Integer templateId;

        @JsonProperty("texts")
        private String[] texts;
    }
}

