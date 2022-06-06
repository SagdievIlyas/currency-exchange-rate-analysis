package com.sagdievilyas.alfabank.currencyexchange.service.giphy;

import com.sagdievilyas.alfabank.currencyexchange.dto.giphy.GifObject;
import com.sagdievilyas.alfabank.currencyexchange.dto.giphy.GiphyResponse;
import com.sagdievilyas.alfabank.currencyexchange.dto.giphy.Meta;
import feign.FeignException;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class GiphyServiceTest {

    @Autowired
    GiphyService giphyService;

    @MockBean
    GiphyClient giphyClient;

    @Test
    public void getGifSuccessTest() {

        EasyRandomParameters parameters = new EasyRandomParameters();
        parameters.stringLengthRange(3, 3);
        EasyRandom generator = new EasyRandom(parameters);
        GifObject gifObject = generator.nextObject(GifObject.class);
        Meta meta = new Meta("message", 200, "testResponseId");
        GiphyResponse successResponse = new GiphyResponse(gifObject, meta);

        Mockito.when(giphyClient.getGif(any(), any())).thenReturn(successResponse);

        assertEquals(gifObject.getUrl(), giphyService.getDecreaseGif());
    }

    @Test
    public void getGifFeignExceptionTest() {
        Mockito.when(giphyClient.getGif(any(), any())).thenThrow(FeignException.class);

        assertEquals(giphyService.getDefaultDecreaseGifUrl(), giphyService.getDecreaseGif());
        assertEquals(giphyService.getDefaultIncreaseGifUrl(), giphyService.getIncreaseGif());
    }

    @Test
    public void getGifResponseIdIsEmptyTest() {
        EasyRandomParameters parameters = new EasyRandomParameters();
        parameters.stringLengthRange(3, 3);
        EasyRandom generator = new EasyRandom(parameters);
        GifObject gifObject = generator.nextObject(GifObject.class);
        Meta meta = new Meta("message", 200, "");
        GiphyResponse successResponse = new GiphyResponse(gifObject, meta);

        Mockito.when(giphyClient.getGif(any(), any())).thenReturn(successResponse);

        assertEquals(giphyService.getDefaultDecreaseGifUrl(), giphyService.getDecreaseGif());
        assertEquals(giphyService.getDefaultIncreaseGifUrl(), giphyService.getIncreaseGif());
    }
}