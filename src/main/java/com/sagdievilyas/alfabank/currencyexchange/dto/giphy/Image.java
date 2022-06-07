package com.sagdievilyas.alfabank.currencyexchange.dto.giphy;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Image {
    @JsonProperty("fixed_height")
    private Gif fixedHeight;

    @JsonProperty("fixed_height_still")
    private Gif fixedHeightStill;

    @JsonProperty("fixed_height_downsampled")
    private Gif fixedHeightDownsampled;

    @JsonProperty("fixed_width")
    private Gif fixedWidth;

    @JsonProperty("fixed_width_still")
    private Gif fixedWidthStill;

    @JsonProperty("fixed_width_downsampled")
    private Gif fixedWidthDownsampled;

    @JsonProperty("fixed_height_small")
    private Gif fixedHeightSmall;

    @JsonProperty("fixed_height_small_still")
    private Gif fixedHeightSmallStill;

    @JsonProperty("fixed_width_small")
    private Gif fixedWidthSmall;

    @JsonProperty("fixed_width_small_still")
    private Gif fixedWidthSmallStill;

    private Gif downsized;

    @JsonProperty("downsized_still")
    private Gif downsizedStill;

    @JsonProperty("downsized_large")
    private Gif downsizedLarge;

    @JsonProperty("downsized_medium")
    private Gif downsizedMedium;

    @JsonProperty("downsized_small")
    private Gif downsizedSmall;

    private Gif original;

    @JsonProperty("original_still")
    private Gif originalStill;

    private Gif looping;

    private Gif preview;

    @JsonProperty("preview_gif")
    private Gif previewGif;
}
