package com.madthreed.currencyservice.clients;

import com.madthreed.currencyservice.models.oer.ExchangeRates;

public interface ExchangeRatesClient {
    ExchangeRates getLatestRates(String apiKey);

    ExchangeRates getHistoricalRates(String apiKey, String date);
}
