package com.madthreed.currencyservice.controllers;

import com.madthreed.currencyservice.models.giphy.Giphy;
import com.madthreed.currencyservice.models.giphy.GiphyWrapper;
import com.madthreed.currencyservice.models.oer.OpenExchangeRateHistoricalBean;
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
import java.util.Map;

@RestController
public class CurrencyServiceController {
    private OpenExchangeRatesAPI openExchangeRatesAPI;
    private GiphyAPI giphyAPI;

    @Autowired
    public CurrencyServiceController(OpenExchangeRatesAPI openExchangeRatesAPI, GiphyAPI giphyAPI) {
        this.openExchangeRatesAPI = openExchangeRatesAPI;
        this.giphyAPI = giphyAPI;
    }

    @Value("${currency-service.httpEndpoint}")
    private String httpEndpoint;

    @Value("${currency-service.OERApiKey}")
    private String oerApiKey;

    @Value("${currency-service.GiphyApiKey}")
    private String giphyApiKey;

    @Value("${currency-service.baseCurrency}")
    private String baseCurrency;


    @GetMapping("/{httpEndpoint}/{targetCurrency}")
    public ResponseEntity<Map> currencyService(@PathVariable String targetCurrency, @PathVariable String httpEndpoint) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.roll(Calendar.DAY_OF_MONTH, -10); //TODO delete
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String nowDate = df.format(calendar.getTime());
        calendar.roll(Calendar.DAY_OF_MONTH, -1);
        String yesterdayDate = df.format(calendar.getTime());

        try {
            OpenExchangeRateHistoricalBean responseNowEntity = openExchangeRatesAPI.retrieveRate(oerApiKey, baseCurrency, targetCurrency, nowDate);
            OpenExchangeRateHistoricalBean responseYesterdayEntity = openExchangeRatesAPI.retrieveRate(oerApiKey, baseCurrency, targetCurrency, yesterdayDate);

            double currExchangeRate = responseNowEntity.getRates().get(targetCurrency);
            double yesterdayExchangeRate = responseYesterdayEntity.getRates().get(targetCurrency);

//            Giphy responseEntity = (currExchangeRate >= yesterdayExchangeRate) ?
//                    giphyAPI.retrieveRandomGif(giphyApiKey, "rich") :
//                    giphyAPI.retrieveRandomGif(giphyApiKey, "broke"); //TODO

            ResponseEntity<Map> responseEntity = giphyAPI.retrieveRandomGif(giphyApiKey, "rich");
            return responseEntity;
        } catch (FeignException e) {
            e.printStackTrace(); // TODO "OpenExchangeRates API error"
        }

//        String r = responseEntity.getData().entrySet().stream().filter(u -> u.getKey().equals("url")).toString();

        return null; //TODO
    }
}
