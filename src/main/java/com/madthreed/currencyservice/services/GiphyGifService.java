package com.madthreed.currencyservice.services;

import com.madthreed.currencyservice.clients.GifClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Set;

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
    public ResponseEntity<?> getGif(String tag) {
        ResponseEntity<?> randomGif = gifClient.retrieveRandomGif(apiKey, tag);

        return randomGif;
    }
}
