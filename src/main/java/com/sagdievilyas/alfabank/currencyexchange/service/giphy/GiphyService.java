package com.sagdievilyas.alfabank.currencyexchange.service.giphy;

import com.sagdievilyas.alfabank.currencyexchange.dto.giphy.GiphyResponse;
import com.sagdievilyas.alfabank.currencyexchange.exception.GiphyNotWorkingException;
import feign.FeignException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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
         try {
             return getGifByTag(increaseTag);
         } catch (GiphyNotWorkingException e) {
             log.error(e.getMessage());
             return defaultIncreaseGifUrl;
         } catch (FeignException e) {
             log.error(e.getMessage());
             return defaultIncreaseGifUrl;
         }
    }

    public String getDecreaseGif() {
        try {
            return getGifByTag(decreaseTag);
        } catch (GiphyNotWorkingException e) {
            log.error(e.getMessage());
            return defaultDecreaseGifUrl;
        } catch (FeignException e) {
            log.error(e.getMessage());
            return defaultDecreaseGifUrl;
        }
    }

    private String getGifByTag(String tag) {
        GiphyResponse response = giphyClient.getGif(giphyApiKey, tag);

        if (response.getMeta().getResponseId().isEmpty()) {
            throw new GiphyNotWorkingException("Giphy API has issues with GIPHY downstream systems.");
        }
        return response.getData().getUrl();
    }
}
