package com.sagdievilyas.alfabank.currencyexchange.dto.openExchangeRate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashMap;

@Getter
@Setter
@AllArgsConstructor
public class CurrencyExchangeRate {
    private String disclaimer;
    private String license;
    private Long timestamp;
    private String base;
    private HashMap<String, BigDecimal> rates;
}
