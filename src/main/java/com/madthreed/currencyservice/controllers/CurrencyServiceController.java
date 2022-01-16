package com.madthreed.currencyservice.controllers;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyServiceController {
//    private FeignOpenExchangeRatesAPIClient feignOpenExchangeRatesAPIClient;
//    private FeignGiphyAPIClient feignGiphyAPIClient;
//
//    @Autowired
//    public CurrencyServiceController(FeignOpenExchangeRatesAPIClient feignOpenExchangeRatesAPIClient, FeignGiphyAPIClient feignGiphyAPIClient) {
//        this.feignOpenExchangeRatesAPIClient = feignOpenExchangeRatesAPIClient;
//        this.feignGiphyAPIClient = feignGiphyAPIClient;
//    }
//
//    @Value("${currency-service.httpEndpoint}")
//    private String httpEndpoint;
//
//    @Value("${currency-service.OERApiKey}")
//    private String oerApiKey;
//
//    @Value("${currency-service.GiphyApiKey}")
//    private String giphyApiKey;
//
//    @Value("${currency-service.baseCurrency}")
//    private String baseCurrency;
//
//
//    @GetMapping("/{httpEndpoint}/{targetCurrency}")
//    public ResponseEntity<Map> currencyService(@PathVariable String targetCurrency, @PathVariable String httpEndpoint) {
//        GregorianCalendar calendar = new GregorianCalendar();
//        calendar.roll(Calendar.DAY_OF_MONTH, -10); //TODO delete
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//        String nowDate = df.format(calendar.getTime());
//        calendar.roll(Calendar.DAY_OF_MONTH, -1);
//        String yesterdayDate = df.format(calendar.getTime());
//
//        try {
//            ExchangeRates responseNowEntity = feignOpenExchangeRatesAPIClient.retrieveRate(oerApiKey, baseCurrency, targetCurrency, nowDate);
//            ExchangeRates responseYesterdayEntity = feignOpenExchangeRatesAPIClient.retrieveRate(oerApiKey, baseCurrency, targetCurrency, yesterdayDate);
//
//            double currExchangeRate = responseNowEntity.getRates().get(targetCurrency);
//            double yesterdayExchangeRate = responseYesterdayEntity.getRates().get(targetCurrency);
//
////            Giphy responseEntity = (currExchangeRate >= yesterdayExchangeRate) ?
////                    giphyAPI.retrieveRandomGif(giphyApiKey, "rich") :
////                    giphyAPI.retrieveRandomGif(giphyApiKey, "broke"); //TODO
//
//            ResponseEntity<Map> responseEntity = feignGiphyAPIClient.retrieveRandomGif(giphyApiKey, "rich");
//            return responseEntity;
//        } catch (FeignException e) {
//            e.printStackTrace(); // TODO "OpenExchangeRates API error"
//        }
//
////        String r = responseEntity.getData().entrySet().stream().filter(u -> u.getKey().equals("url")).toString();
//
//        return null; //TODO
//    }
}
