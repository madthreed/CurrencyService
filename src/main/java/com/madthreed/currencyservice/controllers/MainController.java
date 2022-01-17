package com.madthreed.currencyservice.controllers;

import com.madthreed.currencyservice.services.giphy_service.GifService;
import com.madthreed.currencyservice.services.oer_service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
    public void getRandomGif(@PathVariable("currency") String currency, HttpServletResponse response) throws IOException {

        exchangeRateService.getCompareForCurrencyCode(currency);


        String gifUrl = gifService.getGifUrl("rich");

        response.sendRedirect(gifUrl);
    }
}