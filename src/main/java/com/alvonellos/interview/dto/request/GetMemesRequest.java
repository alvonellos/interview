package com.alvonellos.interview.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GetMemesRequest {
    @JsonProperty("page")
    private Integer page;

    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;
}