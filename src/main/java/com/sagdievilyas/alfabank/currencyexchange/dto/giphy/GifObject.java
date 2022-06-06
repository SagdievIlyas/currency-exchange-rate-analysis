package com.sagdievilyas.alfabank.currencyexchange.dto.giphy;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class GifObject {
    private String type;
    private String id;
    private String slug;
    private String url;
    private String bitly_url;
    private String embed_url;
    private String username;
    private String source;
    private String rating;
    private String content_url;
    private GiphyUser user ;
    private String source_tld;
    private String source_post_url;
    private String update_datetime;
    private String create_datetime;
    private String import_datetime;
    private String trending_datetime;
    private Image images;
    private String title;
}
