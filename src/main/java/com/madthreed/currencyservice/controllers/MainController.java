package com.madthreed.currencyservice.controllers;

import com.madthreed.currencyservice.services.ExchangeRateService;
import com.madthreed.currencyservice.services.GifService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.http.HttpResponse;
import java.util.Scanner;
import java.util.stream.Stream;

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

    @RequestMapping(value = "${httpEndpoint}/get/{currency}", produces = MediaType.IMAGE_GIF_VALUE)
    public ResponseEntity<byte[]> getRandomGif(@PathVariable String currency) {
        try {
            int res = exchangeRateService.getCompareForCurrencyCode(currency);
            String gifUrl = res >= 0 ? gifService.getGifUrl("${gif_name.rich}") : gifService.getGifUrl("${gif_name.broke}");

            String[] subStrings = gifUrl.split("-");
            String gifId = subStrings[subStrings.length-1];
            String gifDirectLink = "https://i.giphy.com/media/"+gifId+"/giphy_s.gif";

            InputStream in = new URL(gifDirectLink).openStream();
            byte[] media = IOUtils.toByteArray(in);

            return new ResponseEntity<>(media, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
}