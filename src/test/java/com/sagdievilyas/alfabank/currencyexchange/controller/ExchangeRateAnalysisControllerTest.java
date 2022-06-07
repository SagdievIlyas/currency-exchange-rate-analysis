package com.sagdievilyas.alfabank.currencyexchange.controller;

import com.sagdievilyas.alfabank.currencyexchange.dto.exchangeRateAnalysis.ExchangeRateAnalysisRequest;
import com.sagdievilyas.alfabank.currencyexchange.exception.BadRequestException;
import com.sagdievilyas.alfabank.currencyexchange.exception.OpenExchangeRateException;
import com.sagdievilyas.alfabank.currencyexchange.service.exchangeRateAnalysis.ExchangeRateAnalysisService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ExchangeRateAnalysisControllerTest {

    private final ExchangeRateAnalysisRequest request = new ExchangeRateAnalysisRequest("EUR");

    @Autowired
    ExchangeRateAnalysisController exchangeRateAnalysisController;

    @MockBean
    ExchangeRateAnalysisService exchangeRateAnalysisService;

    @Test
    public void createAnalysisSuccessTest() {
        String increaseGifUrl = "increaseGifUrl";
        Mockito.when(exchangeRateAnalysisService.analyzeExchangeRate(request)).thenReturn(increaseGifUrl);

        assertEquals(HttpStatus.OK, exchangeRateAnalysisController.createAnalysis(request).getStatusCode());
    }

    @Test
    public void createAnalysisBadRequestExceptionTest() {
        Mockito.when(exchangeRateAnalysisService.analyzeExchangeRate(request)).thenThrow(BadRequestException.class);

        assertEquals(HttpStatus.BAD_REQUEST, exchangeRateAnalysisController.createAnalysis(request).getStatusCode());
    }

    @Test
    public void createAnalysisOpenExchangeRateExceptionTest() {
        Mockito.when(exchangeRateAnalysisService.analyzeExchangeRate(request)).thenThrow(OpenExchangeRateException.class);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, exchangeRateAnalysisController.createAnalysis(request).getStatusCode());
    }
}