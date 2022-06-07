package com.sagdievilyas.alfabank.currencyexchange.dto.giphy;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Gif {
    private String url;

    private String width;

    private String height;

    private String size;

    private String mp4;

    @JsonProperty("mp4_size")
    private String mp4Size;

    private String webp;

    @JsonProperty("webp_size")
    private String webpSize;

    private String frames;
}
