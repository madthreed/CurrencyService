package com.madthreed.currencyservice.clients.feign_clients;

import com.madthreed.currencyservice.clients.ExchangeRatesClient;
import com.madthreed.currencyservice.models.oer.ExchangeRates;
import feign.FeignException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "FeignOpenExchangeRatesAPIProxy", url = "${openexchangerates.url}")
public interface FeignOpenExchangeRatesAPIProxy extends ExchangeRatesClient {
    @RequestMapping("latest.json/?app_id={apiKey}")
    @Override
    ExchangeRates getLatestRates(@PathVariable("apiKey") String apiKey) throws FeignException;

    @RequestMapping("historical/{date}.json?app_id={apiKey}")
    @Override
    ExchangeRates getHistoricalRates(@PathVariable("apiKey") String apiKey,
                                     @PathVariable("date") String date) throws FeignException;
}
