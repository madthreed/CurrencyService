package com.madthreed.currencyservice.services;

public interface ExchangeRateService {
//    List<String> getCurrencyCodes();

    int getCompareForCurrencyCode(String code);

    void refreshRates();
}
