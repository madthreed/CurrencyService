package com.madthreed.currencyservice.services.giphy_service;

import com.madthreed.currencyservice.clients.GifClient;
import com.madthreed.currencyservice.services.giphy_service.GifService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
    public String getGifUrl(String tag) {
        ResponseEntity<String> randomGifResponse = gifClient.retrieveRandomGif(apiKey, tag);


        JSONObject jsonBody = new JSONObject(randomGifResponse.getBody());
        String embed_url = jsonBody.getJSONObject("data").getString("embed_url");

        return embed_url;
    }
}
