package com.madthreed.currencyservice.controllers;

import com.madthreed.currencyservice.models.OpenExchangeRateHistoricalBean;
import com.madthreed.currencyservice.proxies.GiphyAPI;
import com.madthreed.currencyservice.proxies.OpenExchangeRatesAPI;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

@RestController
public class CurrencyServiceController {
    @Autowired
    private OpenExchangeRatesAPI openExchangeRatesAPI;

    @Autowired
    private GiphyAPI giphyAPI;

    @Value("${currency-service.httpEndpoint}")
    private String httpEndpoint;

    @Value("${currency-service.OERApiKey}")
    private String oerApiKey;

    @Value("${currency-service.GiphyApiKey}")
    private String giphyApiKey;

    @Value("${currency-service.baseCurrency}")
    private String baseCurrency;


    @GetMapping("/{httpEndpoint}/{targetCurrency}")
    public ResponseEntity<?> currencyService(@PathVariable String targetCurrency, @PathVariable String httpEndpoint) {
        OpenExchangeRateHistoricalBean responseNowEntity = null;
        OpenExchangeRateHistoricalBean responseYesterdayEntity = null;
        ResponseEntity<?> responseEntity = null;

        double currExchangeRate = 0.0;
        double yesterdayExchangeRate = 0.0;

//        String oerApiKey = environment.getProperty("currency-service.OERApiKey");
//        String giphyApiKey = environment.getProperty("currency-service.GiphyApiKey");
//        String baseCurrency = environment.getProperty("currency-service.baseCurrency");

        GregorianCalendar calendar = new GregorianCalendar();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        calendar.roll(Calendar.DAY_OF_MONTH, -1);

        String nowDate = df.format(calendar.getTime());
        calendar.roll(Calendar.DAY_OF_MONTH, -1);
        String yesterdayDate = df.format(calendar.getTime());

        try {
            responseNowEntity = openExchangeRatesAPI.retrieveRate(oerApiKey, baseCurrency, targetCurrency, nowDate);
            responseYesterdayEntity = openExchangeRatesAPI.retrieveRate(oerApiKey, baseCurrency, targetCurrency, yesterdayDate);

            currExchangeRate = responseNowEntity.getRates().get(targetCurrency);
            yesterdayExchangeRate = responseYesterdayEntity.getRates().get(targetCurrency);
        } catch (FeignException e) {
            e.printStackTrace(); // TODO "OpenExchangeRates API error"
        }


        try {
            responseEntity = (currExchangeRate >= yesterdayExchangeRate) ?
                    giphyAPI.retrieveRandomGif(giphyApiKey, "rich") :
                    giphyAPI.retrieveRandomGif(giphyApiKey, "broke"); //TODO
        } catch (FeignException e) {
            e.printStackTrace(); // TODO "Giphy API error"
        }


        return responseEntity; //TODO
    }
}
