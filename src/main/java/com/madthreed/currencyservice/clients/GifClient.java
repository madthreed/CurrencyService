package com.madthreed.currencyservice.clients;

import com.madthreed.currencyservice.models.giphy.Giphy;
import com.madthreed.currencyservice.models.giphy.GiphyWrapper;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface GifClient {
    Giphy retrieveRandomGif(String apiKey, String tag);
}
