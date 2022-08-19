package com.alvonellos.interview.client;

import com.alvonellos.interview.config.KanyeClientURL;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Validated
@ConfigurationProperties(prefix = "interview.client")
public class ClientProperties {
    @Valid
    @NotNull
    private KanyeClientURL kanyeClientURL;
}

