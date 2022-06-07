package com.sagdievilyas.alfabank.currencyexchange.dto.giphy;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GifObject {
    private String type;

    private String id;

    private String slug;

    private String url;

    @JsonProperty("bitly_url")
    private String bitlyUrl;

    @JsonProperty("embed_url")
    private String embedUrl;

    private String username;

    private String source;

    private String rating;

    @JsonProperty("content_url")
    private String contentUrl;

    private GiphyUser user ;

    @JsonProperty("source_tld")
    private String sourceTld;

    @JsonProperty("source_post_url")
    private String sourcePostUrl;

    @JsonProperty("update_datetime")
    private String updateDatetime;

    @JsonProperty("create_datetime")
    private String createDatetime;

    @JsonProperty("import_datetime")
    private String importDatetime;

    @JsonProperty("trending_datetime")
    private String trendingDatetime;

    private Image images;

    private String title;
}
