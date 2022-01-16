package com.madthreed.currencyservice.proxies;

import com.madthreed.currencyservice.models.giphy.GiphyWrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@FeignClient(name = "GiphyAPI", url = "https://api.giphy.com/v1/gifs/")
public interface GiphyAPI {
    @RequestMapping("random?api_key={apiKey}&tag={tag}")
    ResponseEntity<Map> retrieveRandomGif(@PathVariable("apiKey") String apiKey,
                                          @PathVariable("tag") String tag);
}
