package com.madthreed.currencyservice.feign_proxies;

import com.madthreed.currencyservice.clients.GifClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "FeignGiphyAPIProxy", url = "${giphy.url}")
public interface FeignGiphyAPIProxy extends GifClient {
    @Override
    @RequestMapping("random?api_key={apiKey}&tag={tag}")
    ResponseEntity<String> retrieveRandomGif(@PathVariable("apiKey") String apiKey,
                                                  @PathVariable("tag") String tag);
}
