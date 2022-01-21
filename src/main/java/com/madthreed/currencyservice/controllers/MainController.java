package com.madthreed.currencyservice.controllers;

import com.madthreed.currencyservice.services.ExchangeRateService;
import com.madthreed.currencyservice.services.GifService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RestController
public class MainController {
    private final ExchangeRateService exchangeRateService;
    private final GifService gifService;

    @Autowired
    public MainController(ExchangeRateService exchangeRateService, GifService gifService) {
        this.exchangeRateService = exchangeRateService;
        this.gifService = gifService;
    }

    @RequestMapping("${httpEndpoint}/get/{currency}")
    public String getRandomGif(@PathVariable String currency, HttpServletResponse response) {
        try {
            int res = exchangeRateService.getCompareForCurrencyCode(currency);
            String gifUrl = res >= 0 ? gifService.getGifUrl("${gif_name.rich}") : gifService.getGifUrl("${gif_name.broke}");
//            response.sendRedirect(gifUrl);
            return gifUrl;
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}