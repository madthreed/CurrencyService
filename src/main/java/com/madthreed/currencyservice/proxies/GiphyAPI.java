package com.madthreed.currencyservice.proxies;

import com.madthreed.currencyservice.beans.GiphyBean;
import com.madthreed.currencyservice.beans.OpenExchangeRateHistoricalBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "GiphyAPI", url = "https://api.giphy.com/")
public interface GiphyAPI {
    @RequestMapping("v1/gifs/random?api_key={apiKey}&tag={tag}")
    GiphyBean retrieveRandomGif(@PathVariable("apiKey") String apiKey,
                                @PathVariable("tag") String tag);
}
