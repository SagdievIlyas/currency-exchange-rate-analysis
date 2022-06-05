package com.sagdievilyas.alfabank.currencyexchange.service.openExchangeRate;

import com.sagdievilyas.alfabank.currencyexchange.dto.openExchangeRate.CurrencyExchangeRate;
import com.sagdievilyas.alfabank.currencyexchange.exception.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@RequiredArgsConstructor

@Service
public class OpenExchangeRateService {

    @Value("${openexchangerate.appid}")
    private String openExchangeRateAppId;

    private final OpenExchangeRateClient openExchangeRateClient;

    public BigDecimal getExchangeRate(String code, LocalDate date) {
        CurrencyExchangeRate exchangeRateResponse = openExchangeRateClient.getExchangeRate(date.toString(), openExchangeRateAppId);
        if (exchangeRateResponse.getRates().containsKey(code)) {
            return exchangeRateResponse.getRates().get(code);
        }
        else {
            throw new BadRequestException(String.format("The code: %s does not exist", code));
        }

    }
}
