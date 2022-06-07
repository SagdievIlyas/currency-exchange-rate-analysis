package com.sagdievilyas.alfabank.currencyexchange.service.openExchangeRate;

import com.sagdievilyas.alfabank.currencyexchange.dto.openExchangeRate.CurrencyExchangeRate;
import com.sagdievilyas.alfabank.currencyexchange.exception.BadRequestException;
import com.sagdievilyas.alfabank.currencyexchange.exception.OpenExchangeRateException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@RequiredArgsConstructor
@Slf4j

@Service
public class OpenExchangeRateService {

    @Value("${openexchangerate.appid}")
    private String openExchangeRateAppId;

    private final OpenExchangeRateClient openExchangeRateClient;

    public BigDecimal getExchangeRate(String code, LocalDate date) {
        try {
            CurrencyExchangeRate exchangeRateResponse = openExchangeRateClient.getExchangeRate(date.toString(), openExchangeRateAppId);

            if (exchangeRateResponse.getRates().containsKey(code)) {
                return exchangeRateResponse.getRates().get(code);
            }
            else {
                log.error(String.format("The code: %s does not exist", code));
                throw new BadRequestException(String.format("The code: %s does not exist", code));
            }
        } catch (FeignException e) {
            log.error(e.getMessage());
            throw new OpenExchangeRateException(e.getMessage());
        }
    }
}
