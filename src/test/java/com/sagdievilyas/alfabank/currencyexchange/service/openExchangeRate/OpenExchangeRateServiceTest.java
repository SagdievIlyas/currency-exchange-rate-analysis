package com.sagdievilyas.alfabank.currencyexchange.service.openExchangeRate;

import com.sagdievilyas.alfabank.currencyexchange.dto.openExchangeRate.CurrencyExchangeRate;
import com.sagdievilyas.alfabank.currencyexchange.exception.OpenExchangeRateException;
import feign.FeignException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class OpenExchangeRateServiceTest {

    @Autowired
    OpenExchangeRateService openExchangeRateService;

    @MockBean
    OpenExchangeRateClient openExchangeRateClient;

    @Test
    public void getExchangeRateSuccessTest() {

        HashMap<String, BigDecimal> rates = new HashMap<>();
        String currencyCode = "EUR";
        BigDecimal exchangeRate = BigDecimal.valueOf(0.85);
        rates.put(currencyCode, exchangeRate);
        CurrencyExchangeRate successRate = new CurrencyExchangeRate(
                "disclamer",
                "license",
                1654473599L,
                "USD",
                rates);

        Mockito.when(openExchangeRateClient.getExchangeRate(any(), any())).thenReturn(successRate);

        assertEquals(exchangeRate, openExchangeRateService.getExchangeRate(currencyCode, LocalDate.now()));
    }

    @Test
    public void getExchangeRateOpenExchangeRateExceptionTest() {
        System.out.println("\n\n\t\t FEIGN EXCEPTION TEST");
        Mockito.when(openExchangeRateClient.getExchangeRate(any(), any())).thenThrow(FeignException.class);

        assertThrows(OpenExchangeRateException.class, () -> openExchangeRateService.getExchangeRate("Code", LocalDate.now()));
    }
}