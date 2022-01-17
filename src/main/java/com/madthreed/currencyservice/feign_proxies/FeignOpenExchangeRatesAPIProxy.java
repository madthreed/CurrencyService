package com.madthreed.currencyservice.feign_proxies;

import com.madthreed.currencyservice.clients.ExchangeRatesClient;
import com.madthreed.currencyservice.models.oer.ExchangeRates;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "FeignOpenExchangeRatesAPIProxy", url = "${openexchangerates.url}")
public interface FeignOpenExchangeRatesAPIProxy extends ExchangeRatesClient {
    @RequestMapping("latest.json/?app_id={apiKey}")
    @Override
    ExchangeRates getLatestRates(@PathVariable("apiKey") String apiKey);

    @RequestMapping("historical/{date}.json?app_id={apiKey}")
    @Override
    ExchangeRates getHistoricalRates(@PathVariable("apiKey") String apiKey,
                                     @PathVariable("date") String date);

    //    @RequestMapping("historical/{date}.json?app_id={appIdToken}&base={baseCurrency}&symbols={targetCurrency}")
//    ExchangeRates retrieveRate(@PathVariable("appIdToken") String appIdToken,
//                               @PathVariable String baseCurrency,
//                               @PathVariable String targetCurrency,
//                               @PathVariable String date);
}
