package com.sagdievilyas.alfabank.currencyexchange.service.openExchangeRate;

import com.sagdievilyas.alfabank.currencyexchange.dto.openExchangeRate.CurrencyExchangeRate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "open-exchange-rate-client", url = "https://openexchangerates.org")
public interface OpenExchangeRateClient {
    @GetMapping("/api/historical/{rateDate}.json")
    CurrencyExchangeRate getExchangeRate(@PathVariable("rateDate") String rateDate,
                                         @RequestParam(value = "app_id") String appId);
}
