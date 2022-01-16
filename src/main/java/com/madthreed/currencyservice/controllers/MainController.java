package com.madthreed.currencyservice.controllers;

import com.madthreed.currencyservice.services.ExchangeRateService;
import com.madthreed.currencyservice.services.GifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/{httpEndpoint}")
public class MainController {
    private ExchangeRateService exchangeRateService;
    private GifService gifService;

    @Autowired
    public MainController(ExchangeRateService exchangeRateService, GifService gifService) {
        this.exchangeRateService = exchangeRateService;
        this.gifService = gifService;
    }

    @GetMapping("/get-random-gif/{currency}")
    public Integer getRandomGif(@PathVariable("currency") String currency) throws IOException {
        ResponseEntity<?> gif = gifService.getGif("rich");

        Map map = (LinkedHashMap) gif.getBody();

        exchangeRateService.getCompareForCurrencyCode(currency);

        return null;
    }
}
