package com.alvonellos.interview.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemeTemplateDTO {
    @JsonProperty("ID")
    private Long id;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("AlternateNames")
    private String alternateNames;
}