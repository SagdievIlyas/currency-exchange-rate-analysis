package com.sagdievilyas.alfabank.currencyexchange.dto.giphy;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GiphyUser {
    @JsonProperty("avatar_url")
    private String avatarUrl;

    @JsonProperty("banner_url")
    private String bannerUrl;

    @JsonProperty("profile_url")
    private String profileUrl;

    private String username;

    @JsonProperty("display_name")
    private String displayName;
}
