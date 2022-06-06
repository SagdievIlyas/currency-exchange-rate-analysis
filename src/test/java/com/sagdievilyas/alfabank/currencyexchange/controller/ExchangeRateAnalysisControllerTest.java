package com.sagdievilyas.alfabank.currencyexchange.controller;

import com.sagdievilyas.alfabank.currencyexchange.dto.exchangeRateAnalysis.ExchangeRateAnalysisRequest;
import com.sagdievilyas.alfabank.currencyexchange.dto.exchangeRateAnalysis.ExchangeRateAnalysisResponse;
import com.sagdievilyas.alfabank.currencyexchange.service.exchangeRateAnalysis.ExchangeRateAnalysisService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ExchangeRateAnalysisControllerTest {

    private final ExchangeRateAnalysisRequest request = new ExchangeRateAnalysisRequest("EUR");
    private final String increaseGifUrl = "increaseGifUrl";
    private final ResponseEntity<?> successResponse = ResponseEntity.ok(new ExchangeRateAnalysisResponse(increaseGifUrl));

    @Autowired
    ExchangeRateAnalysisController exchangeRateAnalysisController;

    @MockBean
    ExchangeRateAnalysisService exchangeRateAnalysisService;

    @Test
    public void createAnalysisSuccessTest() {
        Mockito.when(exchangeRateAnalysisService.analyzeExchangeRate(request)).thenReturn(increaseGifUrl);

        assertEquals(HttpStatus.OK, exchangeRateAnalysisController.createAnalysis(request).getStatusCode());
    }

}