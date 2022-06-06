package com.sagdievilyas.alfabank.currencyexchange.service.exchangeRateAnalysis;

import com.sagdievilyas.alfabank.currencyexchange.dto.exchangeRateAnalysis.ExchangeRateAnalysisRequest;
import com.sagdievilyas.alfabank.currencyexchange.dto.giphy.GifObject;
import com.sagdievilyas.alfabank.currencyexchange.dto.giphy.GiphyResponse;
import com.sagdievilyas.alfabank.currencyexchange.dto.giphy.Meta;
import com.sagdievilyas.alfabank.currencyexchange.service.giphy.GiphyClient;
import com.sagdievilyas.alfabank.currencyexchange.service.giphy.GiphyService;
import com.sagdievilyas.alfabank.currencyexchange.service.openExchangeRate.OpenExchangeRateService;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class ExchangeRateAnalysisServiceTest {

    @Autowired
    ExchangeRateAnalysisService exchangeRateAnalysisService;

    @MockBean
    GiphyService giphyService;

    @MockBean
    OpenExchangeRateService openExchangeRateService;

    private final String increaseGifUrl = "increaseGifUrl";
    private final String decreaseGifUrl = "decreaseGifUrl";
    private final ExchangeRateAnalysisRequest request = new ExchangeRateAnalysisRequest("EUR");
    private final LocalDate todayUTC = ZonedDateTime.now(ZoneOffset.UTC).toLocalDate();
    private final LocalDate yesterdayUTC = todayUTC.minusDays(1);


    @Test
    public void analyzeExchangeRateSuccessIncreaseTest() {
        BigDecimal todaySuccessExchangeRate = BigDecimal.valueOf(2.0);
        BigDecimal yesterdaySuccessExchangeRate = BigDecimal.valueOf(1.0);

        Mockito.when(openExchangeRateService.getExchangeRate(request.getCode(), todayUTC)).thenReturn(todaySuccessExchangeRate);
        Mockito.when(openExchangeRateService.getExchangeRate(request.getCode(), yesterdayUTC)).thenReturn(yesterdaySuccessExchangeRate);

        Mockito.when(giphyService.getIncreaseGif()).thenReturn(increaseGifUrl);

        assertEquals(increaseGifUrl, exchangeRateAnalysisService.analyzeExchangeRate(request));
    }

    @Test
    public void analyzeExchangeRateSuccessDecreaseTest(){
        BigDecimal todaySuccessExchangeRate = BigDecimal.valueOf(1.0);
        BigDecimal yesterdaySuccessExchangeRate = BigDecimal.valueOf(2.0);

        Mockito.when(openExchangeRateService.getExchangeRate(request.getCode(), todayUTC)).thenReturn(todaySuccessExchangeRate);
        Mockito.when(openExchangeRateService.getExchangeRate(request.getCode(), yesterdayUTC)).thenReturn(yesterdaySuccessExchangeRate);

        Mockito.when(giphyService.getDecreaseGif()).thenReturn(decreaseGifUrl);

        assertEquals(decreaseGifUrl, exchangeRateAnalysisService.analyzeExchangeRate(request));
    }



}