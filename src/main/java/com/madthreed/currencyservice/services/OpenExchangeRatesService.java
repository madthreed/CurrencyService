package com.madthreed.currencyservice.services;

import com.madthreed.currencyservice.clients.FeignOpenExchangeRatesAPIClient;
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

    FeignOpenExchangeRatesAPIClient feignOpenExchangeRatesAPIClient;

    @Value("${openexchangerates.baseCurrency}")
    String baseCurrency;

    @Value("${openexchangerates.apiKey}")
    String apiKey;


    @Autowired
    public OpenExchangeRatesService(FeignOpenExchangeRatesAPIClient feignOpenExchangeRatesAPIClient) {
        this.feignOpenExchangeRatesAPIClient = feignOpenExchangeRatesAPIClient;
    }

    @Override
    public List<String> getCurrencyCodes() {
        List<String> codes = null;
        refreshRates();
        if (currRates != null) {
            codes = new ArrayList<>(currRates.getRates().keySet());
        }
        return codes;
    }

    @Override
    public int getCurrencyRatioForCode(String currencyCode) {
        refreshRates();
        Double prevCoef = getCoef(prevRates, currencyCode);
        Double currentCoef = getCoef(currRates, currencyCode);

        int coef = Double.compare(prevCoef,currentCoef);

        return 0;
    }

    @Override
    public void refreshRates() {
        long currentTime = System.currentTimeMillis();
        refreshCurrentRates(currentTime);
        refreshPreviousRates(currentTime);
    }

    private void refreshCurrentRates(long currentTime) {
        currRates = feignOpenExchangeRatesAPIClient.getLatestRates(apiKey);
    }

    private void refreshPreviousRates(long currentTime) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(currentTime);
        calendar.roll(Calendar.DAY_OF_MONTH, -1); //TODO -1
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String yesterdayDate = df.format(calendar.getTime());

        prevRates = feignOpenExchangeRatesAPIClient.getHistoricalRates(apiKey, yesterdayDate);
    }

    private Double getCoef(ExchangeRates rates, String currencyCode) {
        if (rates == null || rates.getRates() == null)
            return null;

        Map<String, Double> map = rates.getRates();
        Double targetCurrency = map.get(currencyCode);
        Double baseCurrency = map.get(rates.getBase());
        Double appBaseCurrency = map.get(this.baseCurrency);

        return new BigDecimal((baseCurrency / appBaseCurrency) * targetCurrency).doubleValue();
    }
}
