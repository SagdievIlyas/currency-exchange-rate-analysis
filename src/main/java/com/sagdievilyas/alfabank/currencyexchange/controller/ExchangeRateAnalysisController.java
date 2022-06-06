package com.sagdievilyas.alfabank.currencyexchange.controller;

import com.sagdievilyas.alfabank.currencyexchange.dto.exchangeRateAnalysis.BadResponse;
import com.sagdievilyas.alfabank.currencyexchange.dto.exchangeRateAnalysis.ExchangeRateAnalysisRequest;
import com.sagdievilyas.alfabank.currencyexchange.dto.exchangeRateAnalysis.ExchangeRateAnalysisResponse;
import com.sagdievilyas.alfabank.currencyexchange.exception.BadRequestException;
import com.sagdievilyas.alfabank.currencyexchange.service.exchangeRateAnalysis.ExchangeRateAnalysisService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor

@RestController
@RequestMapping("api/v1/analysis")
public class ExchangeRateAnalysisController {
    private final ExchangeRateAnalysisService exchangeRateAnalysisService;

    @PostMapping("/create")
    public ResponseEntity<?> createAnalysis(ExchangeRateAnalysisRequest request) {
        try {
            String resultGifUrl = exchangeRateAnalysisService.analyzeExchangeRate(request);
            return ResponseEntity.ok(new ExchangeRateAnalysisResponse(resultGifUrl));
        } catch (BadRequestException e) {
            return ResponseEntity.badRequest().body(new BadResponse(e.getMessage()));
        }
    }
}
