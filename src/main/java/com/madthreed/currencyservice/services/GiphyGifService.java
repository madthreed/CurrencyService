package com.madthreed.currencyservice.services;

import com.madthreed.currencyservice.clients.GifClient;
import com.madthreed.currencyservice.models.giphy.Giphy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class GiphyGifService implements GifService {
    private GifClient gifClient;

    @Value("${giphy.apiKey}")
    String apiKey;

    @Autowired
    public GiphyGifService(GifClient gifClient) {
        this.gifClient = gifClient;
    }

    @Override
    public Giphy getGif(String tag) {
        Giphy randomGif = gifClient.retrieveRandomGif(apiKey, tag);

        return randomGif;
    }
}
