package com.sagdievilyas.alfabank.currencyexchange.service.giphy;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor

@Service
public class GiphyService {

    @Value("${giphy.apikey}")
    private String giphyApiKey;

    private final GiphyClient giphyClient;

    public String getGifByTag(String tag) {
        return giphyClient.getGif(giphyApiKey, tag).getData().getUrl();
    }
}
