package com.sagdievilyas.alfabank.currencyexchange.service.exchangeRateAnalysis;

import com.sagdievilyas.alfabank.currencyexchange.dto.exchangeRateAnalysis.ExchangeRateAnalysisRequest;
import com.sagdievilyas.alfabank.currencyexchange.exception.BadRequestException;
import com.sagdievilyas.alfabank.currencyexchange.exception.OpenExchangeRateException;
import com.sagdievilyas.alfabank.currencyexchange.service.giphy.GiphyService;
import com.sagdievilyas.alfabank.currencyexchange.service.openExchangeRate.OpenExchangeRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;


@RequiredArgsConstructor

@Service
public class ExchangeRateAnalysisService {

    private final OpenExchangeRateService openExchangeRateService;
    private final GiphyService giphyService;

    public String analyzeExchangeRate(ExchangeRateAnalysisRequest request) {
        LocalDate todayUTC = ZonedDateTime.now(ZoneOffset.UTC).toLocalDate();
        LocalDate yesterdayUTC = todayUTC.minusDays(1);

        BigDecimal todayRate = openExchangeRateService.getExchangeRate(request.getCode(), todayUTC);
        BigDecimal yesterdayRate = openExchangeRateService.getExchangeRate(request.getCode(), yesterdayUTC);

        if (todayRate.compareTo(yesterdayRate) >= 0) {
            return giphyService.getIncreaseGif();
        }
        else { return giphyService.getDecreaseGif(); }
    }
}
