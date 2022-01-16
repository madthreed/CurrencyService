package com.madthreed.currencyservice.services;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ExchangeRateService {
    List<String> getCurrencyCodes();

    int getCurrencyRatioForCode(String code);

    void refreshRates();
}
