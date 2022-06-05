package com.sagdievilyas.alfabank.currencyexchange.dto.openExchangeRate;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashMap;

@Getter
@Setter
public class CurrencyExchangeRate {
    private String disclaimer;
    private String license;
    private Long timestamp;
    private String base;
    private HashMap<String, BigDecimal> rates;
}
