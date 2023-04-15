package com.alvonellos.interview.dto.request;

import com.alvonellos.interview.dto.BoxDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CaptionImageRequestDTO {
    @JsonProperty("template_id")
    private int templateId;

    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;

    @JsonProperty("text0")
    private String text0;

    @JsonProperty("text1")
    private String text1;

    @JsonProperty("font")
    private String font;

    @JsonProperty("max_font_size")
    private int maxFontSize;

    @JsonProperty("no_watermark")
    private boolean noWatermark;

    @JsonProperty("boxes")
    private BoxDTO[] boxes;
}

