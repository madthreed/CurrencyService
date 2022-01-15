package com.madthreed.currencyservice.proxies;

import com.madthreed.currencyservice.beans.OpenExchangeRateHistoricalBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "OpenExchangeRatesAPI", url = "https://openexchangerates.org/api/")
public interface OpenExchangeRatesAPI {
    @RequestMapping("historical/{date}.json?app_id={appIdToken}&base={baseCurrency}&symbols={targetCurrency}")
    OpenExchangeRateHistoricalBean retrieveRate(@PathVariable("appIdToken") String appIdToken,
                                                @PathVariable String baseCurrency,
                                                @PathVariable String targetCurrency,
                                                @PathVariable String date);
}
