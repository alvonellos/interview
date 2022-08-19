package com.alvonellos.interview.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Validated
public class KanyeClientURL {
    @NotBlank
    private String scheme;

    @NotBlank
    private String baseUrl;

    @NotBlank
    private String resourcePath;
}
