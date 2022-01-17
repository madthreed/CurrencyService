package com.madthreed.currencyservice.services.oer_service;

public interface ExchangeRateService {
//    List<String> getCurrencyCodes();

    int getCompareForCurrencyCode(String code);

    void refreshRates();
}
