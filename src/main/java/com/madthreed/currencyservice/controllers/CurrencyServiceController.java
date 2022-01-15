package com.madthreed.currencyservice.controllers;

import com.madthreed.currencyservice.beans.GiphyBean;
import com.madthreed.currencyservice.beans.OpenExchangeRateHistoricalBean;
import com.madthreed.currencyservice.props.CurrencyServiceProperties;
import com.madthreed.currencyservice.proxies.GiphyAPI;
import com.madthreed.currencyservice.proxies.OpenExchangeRatesAPI;
import feign.FeignException;
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
//    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private OpenExchangeRatesAPI openExchangeRatesAPI;

    @Autowired
    private GiphyAPI giphyAPI;

    @Autowired
    private CurrencyServiceProperties currencyServiceProperties;

    @GetMapping("/{httpEndpoint}/{targetCurrency}")
    public String currencyService(@PathVariable String httpEndpoint, @PathVariable String targetCurrency) {
        double currExchangeRate = 0.0;
        double yesterdayExchangeRate = 0.0;

        String oerApiKey = currencyServiceProperties.getOERApiKey();
        String giphyApiKey = currencyServiceProperties.getGiphyApiKey();
        String baseCurrency = currencyServiceProperties.getBaseCurrency();

        GregorianCalendar calendar = new GregorianCalendar();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        String nowDate = df.format(calendar.getTime());
        calendar.roll(Calendar.DAY_OF_MONTH, -1);
        String yesterdayDate = df.format(calendar.getTime());

        try {
            OpenExchangeRateHistoricalBean responseNowEntity = openExchangeRatesAPI.retrieveRate(oerApiKey, baseCurrency, targetCurrency, nowDate);
            OpenExchangeRateHistoricalBean responseYesterdayEntity = openExchangeRatesAPI.retrieveRate(oerApiKey, baseCurrency, targetCurrency, yesterdayDate);

            currExchangeRate = responseNowEntity.getRates().get(targetCurrency);
            yesterdayExchangeRate = responseYesterdayEntity.getRates().get(targetCurrency);

//            logger.info("{}", responseNowEntity);
//            logger.info("{}", responseYesterdayEntity);
        } catch (FeignException e) {
            e.printStackTrace(); // TODO "OpenExchangeRates API error"
        }

        try {
            if (currExchangeRate >= yesterdayExchangeRate) {
                GiphyBean responseEntity = giphyAPI.retrieveRandomGif(giphyApiKey, "rich"); //TODO
                System.out.println("show 1");
            } else {
                System.out.println("show 2");
            }
        } catch (FeignException e) {
            e.printStackTrace();
        }


        return "dfdfd";
    }
}
