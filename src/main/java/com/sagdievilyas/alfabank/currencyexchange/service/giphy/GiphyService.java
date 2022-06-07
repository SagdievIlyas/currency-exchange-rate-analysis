package com.sagdievilyas.alfabank.currencyexchange.service.giphy;

import com.sagdievilyas.alfabank.currencyexchange.dto.giphy.GifObject;
import com.sagdievilyas.alfabank.currencyexchange.dto.giphy.GiphyResponse;
import com.sagdievilyas.alfabank.currencyexchange.exception.GiphyNotWorkingException;
import feign.FeignException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Getter
@Slf4j

@Service
public class GiphyService {

    @Value("${giphy.apikey}")
    private String giphyApiKey;

    @Value("${giphy.tag.increaseTag}")
    private String increaseTag;

    @Value("${giphy.tag.decreaseTag}")
    private String decreaseTag;

    @Value("giphy.default.url.increaseGifUrl")
    private String defaultIncreaseGifUrl;

    @Value("giphy.default.url.decreaseGifUrl")
    private String defaultDecreaseGifUrl;

    private final GiphyClient giphyClient;

    public String getIncreaseGif() {
        return getGifByTag(increaseTag).orElseGet(() -> defaultIncreaseGifUrl);
    }

    public String getDecreaseGif() {
        return getGifByTag(decreaseTag).orElseGet(() -> defaultDecreaseGifUrl);
    }

    private Optional<String> getGifByTag(String tag) {
        try{
            GiphyResponse response = giphyClient.getGif(giphyApiKey, tag);

            if (response.getMeta().getResponseId().isEmpty()) {
                log.error("Giphy returns empty response_id");
                return Optional.empty();
            }

            return Optional.ofNullable(response)
                    .map(GiphyResponse::getData)
                    .map((GifObject::getUrl));

        } catch (FeignException e) {
            log.error(e.getMessage());
            return Optional.empty();
        }
    }
}
