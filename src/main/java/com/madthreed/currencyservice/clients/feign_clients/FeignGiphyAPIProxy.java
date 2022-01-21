package com.madthreed.currencyservice.clients.feign_clients;

import com.madthreed.currencyservice.clients.GifClient;
import feign.FeignException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "FeignGiphyAPIProxy", url = "${giphy.url}")
public interface FeignGiphyAPIProxy extends GifClient {
    @Override
    @RequestMapping("random?api_key={apiKey}&tag={tag}")
    ResponseEntity<String> retrieveRandomGif(@PathVariable("apiKey") String apiKey,
                                             @PathVariable("tag") String tag) throws FeignException;
}
