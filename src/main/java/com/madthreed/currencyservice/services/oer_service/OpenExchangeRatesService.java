package com.madthreed.currencyservice.services.oer_service;

import com.madthreed.currencyservice.clients.ExchangeRatesClient;
import com.madthreed.currencyservice.models.oer.ExchangeRates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class OpenExchangeRatesService implements ExchangeRateService {
    private ExchangeRates prevRates;
    private ExchangeRates currRates;

    ExchangeRatesClient exchangeRatesClient;

    @Value("${openexchangerates.baseCurrency}")
    String baseCurrency;

    @Value("${openexchangerates.apiKey}")
    String apiKey;


    @Autowired
    public OpenExchangeRatesService(ExchangeRatesClient exchangeRatesClient) {
        this.exchangeRatesClient = exchangeRatesClient;
    }

    @Override
    public int getCompareForCurrencyCode(String currencyCode) {
        refreshRates();
        Double currentCrossRate = getCrossExchangeRate(currRates, currencyCode);
        Double prevCrossRate = getCrossExchangeRate(prevRates, currencyCode);

        return Double.compare(currentCrossRate, prevCrossRate);
    }

    @Override
    public void refreshRates() {
        long currentTime = System.currentTimeMillis();
        refreshCurrentRates(currentTime);
        refreshPreviousRates(currentTime);
    }

    private void refreshCurrentRates(long currentTime) {
        currRates = exchangeRatesClient.getLatestRates(apiKey);
    }

    private void refreshPreviousRates(long currentTime) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(currentTime);
        calendar.roll(Calendar.DAY_OF_MONTH, -1); //TODO -1
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String yesterdayDate = df.format(calendar.getTime());

        prevRates = exchangeRatesClient.getHistoricalRates(apiKey, yesterdayDate);
    }

    // Free version of OER has only USD base currency

    private Double getCrossExchangeRate(ExchangeRates rates, String currencyCode) {
        if (rates == null || rates.getRates() == null)
            return null;

        Map<String, Double> map = rates.getRates();
        Double baseCurrency = map.get(rates.getBase()); // Free version of OER has only USD base currency
        Double targetCurrency = map.get(currencyCode);
        Double appBaseCurrency = map.get(this.baseCurrency);

        return new BigDecimal(baseCurrency * targetCurrency / appBaseCurrency ).doubleValue();
    }
}
