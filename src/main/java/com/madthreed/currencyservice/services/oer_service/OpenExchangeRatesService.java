package com.madthreed.currencyservice.services.oer_service;

import com.madthreed.currencyservice.clients.ExchangeRatesClient;
import com.madthreed.currencyservice.models.oer.ExchangeRates;
import com.madthreed.currencyservice.services.ExchangeRateService;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map;

@Service
public class OpenExchangeRatesService implements ExchangeRateService {
    private final ExchangeRatesClient exchangeRatesClient;

    private ExchangeRates prevRates;
    private ExchangeRates currRates;

    @Value("${openexchangerates.baseCurrency}")
    String baseCurrency;

    @Value("${openexchangerates.apiKey}")
    String apiKey;


    @Autowired
    public OpenExchangeRatesService(ExchangeRatesClient exchangeRatesClient) {
        this.exchangeRatesClient = exchangeRatesClient;
    }

    @Override
    public int getCompareForCurrencyCode(String currencyCode) throws IOException {
        try {
            refreshRates();
        } catch (FeignException e) {
            e.printStackTrace();
            throw new IOException("Can't retrieve exchange rates from OpenExchangeRate.org");
        }

        Double currentCrossRate = getCrossExchangeRate(currRates, currencyCode);
        Double prevCrossRate = getCrossExchangeRate(prevRates, currencyCode);

        return Double.compare(currentCrossRate, prevCrossRate);
    }

    private void refreshRates() {
        long currentTime = System.currentTimeMillis();
        refreshCurrentRates();
        refreshPreviousRates(currentTime);
    }

    private void refreshCurrentRates() {
        currRates = exchangeRatesClient.getLatestRates(this.apiKey);
    }

    private void refreshPreviousRates(long currentTime) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(currentTime);
        calendar.roll(Calendar.DAY_OF_MONTH, -1); //TODO -1
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String yesterdayDate = df.format(calendar.getTime());

        prevRates = exchangeRatesClient.getHistoricalRates(this.apiKey, yesterdayDate);
    }

    // Free version of OER has only USD base currency, so we use cross rates

    private Double getCrossExchangeRate(ExchangeRates rates, String currencyCode) {
        if (rates == null || rates.getRates() == null)
            return null;

        Map<String, Double> map = rates.getRates();
        Double baseCurrency = map.get(rates.getBase());
        Double targetCurrency = map.get(currencyCode);
        Double appBaseCurrency = map.get(this.baseCurrency);

        return new BigDecimal(baseCurrency * targetCurrency / appBaseCurrency).doubleValue();
    }
}
