package com.madthreed.currencyservice.clients;

import com.madthreed.currencyservice.models.oer.ExchangeRates;
import feign.FeignException;

import java.io.IOException;

public interface ExchangeRatesClient {
    ExchangeRates getLatestRates(String apiKey) throws FeignException;

    ExchangeRates getHistoricalRates(String apiKey, String date) throws FeignException;
}
