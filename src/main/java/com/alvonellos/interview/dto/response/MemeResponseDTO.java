package com.alvonellos.interview.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = false)
public class MemeResponseDTO {
    private boolean success;
    private Memes data;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = false)
    public static class Memes {
        @JsonProperty("memes")
        private MemeDTO[] memes;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = false)
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MemeDTO {
        private Long id;
        private String name;
        private String url;
        private int width;
        private int height;
        @JsonProperty("box_count")
        private int boxCount;
    }
}