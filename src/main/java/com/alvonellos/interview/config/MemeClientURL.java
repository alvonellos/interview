package com.alvonellos.interview.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Validated
public class MemeClientURL {

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String scheme;

    @NotBlank
    private String baseUrl;

    @NotBlank
    private String resourcePath;

    @NotBlank
    private String getMemesPath;

    @NotBlank
    private String captionImagePath;

    @NotBlank
    private String searchMemesPath;

    @NotBlank
    private String autoMemePath;

    @NotBlank
    private String aiMemePath;

    @NotBlank
    private String getTopPath;
}
