package com.madthreed.currencyservice.controllers;

import com.madthreed.currencyservice.services.ExchangeRateService;
import com.madthreed.currencyservice.services.GifService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Микросервис обращается к сервису курсов валют https://openexchangerates.org/
 * и отдает gif в ответ:
 * если курс по отношению к рублю за сегодня стал выше вчерашнего,
 * то отдаем случайную картинку отсюда https://giphy.com/search/rich
 * если ниже - отсюда https://giphy.com/search/broke
 *
 * ------------------------
 * Параметры сервиса находятся в файле application.properties
 * httpEndpoint - эндпоинт сервиса
 * openexchangerates.url
 * openexchangerates.apiKey - api-ключ пользователя
 * openexchangerates.baseCurrency - валюта по отношению к которой смотрится курс
 *
 * giphy.url
 * giphy.apiKey - api-ключ пользователя
 *
 * gif_name.rich - тег картинки
 * gif_name.broke - тег картинки
 * ------------------------
 *
 * Обращение к сервису с параметрами по-умолчанию: /rnd-gif/get?currency=RUB
 * где RUB - валюта для сравнения
 */

@Slf4j
@RestController
@RequestMapping("${httpEndpoint}")
public class MainController {
    private final ExchangeRateService exchangeRateService;
    private final GifService gifService;

    @Value("${gif_name.rich}")
    private String richTag;
    @Value("${gif_name.broke}")
    private String brokeTag;

    @Autowired
    public MainController(ExchangeRateService exchangeRateService, GifService gifService) {
        this.exchangeRateService = exchangeRateService;
        this.gifService = gifService;
    }

    @GetMapping("/get")
    public String getRandomGif(@RequestParam("currency") String currency) {
        try {
            int res = exchangeRateService.getCompareForCurrencyCode(currency);
            return res >= 0 ? gifService.getGifUrl(this.richTag) : gifService.getGifUrl(this.brokeTag);
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }

//        response.sendRedirect(gifUrl);
    }
}