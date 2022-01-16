package com.madthreed.currencyservice.proxies;

import com.madthreed.currencyservice.clients.GifClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@FeignClient(name = "FeignGiphyAPIProxy", url = "${giphy.url}")
public interface FeignGiphyAPIProxy extends GifClient {
    @Override
    @RequestMapping("random?api_key={apiKey}&tag={tag}")
    ResponseEntity<?> retrieveRandomGif(@PathVariable("apiKey") String apiKey,
                                                  @PathVariable("tag") String tag);
}