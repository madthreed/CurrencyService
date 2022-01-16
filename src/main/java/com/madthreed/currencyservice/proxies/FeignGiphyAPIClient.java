package com.madthreed.currencyservice.proxies;

import com.madthreed.currencyservice.clients.GifClient;
import com.madthreed.currencyservice.models.giphy.Giphy;
import com.madthreed.currencyservice.models.giphy.GiphyWrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@FeignClient(name = "FeignGiphyAPIClient", url = "${giphy.url}")
public interface FeignGiphyAPIClient extends GifClient {
    @Override
    @RequestMapping("random?api_key={apiKey}&tag={tag}")
    Giphy retrieveRandomGif(@PathVariable("apiKey") String apiKey,
                            @PathVariable("tag") String tag);
}
