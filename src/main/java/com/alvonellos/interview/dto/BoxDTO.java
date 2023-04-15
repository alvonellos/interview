package com.alvonellos.interview.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BoxDTO {
    @JsonProperty("text")
    private String text;

    @JsonProperty("x")
    private int x;

    @JsonProperty("y")
    private int y;

    @JsonProperty("width")
    private int width;

    @JsonProperty("height")
    private int height;

    @JsonProperty("color")
    private String color;

    @JsonProperty("outline_color")
    private String outlineColor;
}
