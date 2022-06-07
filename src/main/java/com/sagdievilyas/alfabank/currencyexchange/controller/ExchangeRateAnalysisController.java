package com.sagdievilyas.alfabank.currencyexchange.controller;

import com.sagdievilyas.alfabank.currencyexchange.dto.exchangeRateAnalysis.BadResponse;
import com.sagdievilyas.alfabank.currencyexchange.dto.exchangeRateAnalysis.ExchangeRateAnalysisRequest;
import com.sagdievilyas.alfabank.currencyexchange.dto.exchangeRateAnalysis.ExchangeRateAnalysisResponse;
import com.sagdievilyas.alfabank.currencyexchange.exception.BadRequestException;
import com.sagdievilyas.alfabank.currencyexchange.exception.OpenExchangeRateException;
import com.sagdievilyas.alfabank.currencyexchange.service.exchangeRateAnalysis.ExchangeRateAnalysisService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@Slf4j

@RestController
@RequestMapping("api/v1/analysis")
public class ExchangeRateAnalysisController {
    private final ExchangeRateAnalysisService exchangeRateAnalysisService;

    @GetMapping("/create")
    public ResponseEntity<?> createAnalysis(ExchangeRateAnalysisRequest request) {
        try {
            String resultGifUrl = exchangeRateAnalysisService.analyzeExchangeRate(request);
            return ResponseEntity.ok(new ExchangeRateAnalysisResponse(resultGifUrl));
        } catch (BadRequestException e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().body(new BadResponse("Invalid currency code"));
        } catch (OpenExchangeRateException e) {
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().body(new BadResponse("Rate service is not available"));
        }
    }
}
