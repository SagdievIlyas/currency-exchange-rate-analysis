package com.sagdievilyas.alfabank.currencyexchange.service.giphy;

import com.sagdievilyas.alfabank.currencyexchange.dto.giphy.GiphyResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "giphy-client", url = "https://api.giphy.com")
public interface GiphyClient {
    @GetMapping("/v1/gifs/random")
    GiphyResponse getGif(@RequestParam(value = "api_key") String api_key,
                         @RequestParam(value = "tag") String tag);
}
