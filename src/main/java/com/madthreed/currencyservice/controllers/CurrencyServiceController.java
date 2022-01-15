package com.madthreed.currencyservice.controllers;

import com.madthreed.currencyservice.beans.OpenExchangeRateHistoricalBean;
import com.madthreed.currencyservice.props.CurrencyServiceProperties;
import com.madthreed.currencyservice.proxies.OpenExchangeRatesAPI;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

@RestController
public class CurrencyServiceController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private OpenExchangeRatesAPI openExchangeRatesAPI;

    @Autowired
    private CurrencyServiceProperties currencyServiceProperties;

    @GetMapping("/{httpEndpoint}/{targetCurrency}")
    public void currencyService(@PathVariable String httpEndpoint, @PathVariable String targetCurrency) {
        OpenExchangeRateHistoricalBean responseNowEntity;
        OpenExchangeRateHistoricalBean responseYesterdayEntity;

        String token = currencyServiceProperties.getOerApiToken();
        String baseCurrency = currencyServiceProperties.getBaseCurrency();

        GregorianCalendar calendar = new GregorianCalendar();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        String nowDate = df.format(calendar.getTime());
        calendar.roll(Calendar.DAY_OF_MONTH, -1);
        String yesterdayDate= df.format(calendar.getTime());

        try {
            responseNowEntity = openExchangeRatesAPI.retrieveRate(token, baseCurrency, targetCurrency, nowDate);
            responseYesterdayEntity = openExchangeRatesAPI.retrieveRate(token, baseCurrency, targetCurrency, yesterdayDate);

            logger.info("{}", responseNowEntity);
            logger.info("{}", responseYesterdayEntity);
        } catch (FeignException e) {
            e.printStackTrace(); // TODO "OpenExchangeRates API error"
        }
    }
}
