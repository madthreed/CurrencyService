package com.madthreed.currencyservice.services.giphy_service;

import com.madthreed.currencyservice.clients.GifClient;
import com.madthreed.currencyservice.services.GifService;
import feign.FeignException;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InvalidObjectException;

@Service
public class GiphyGifService implements GifService {
    private final GifClient gifClient;

    @Value("${giphy.apiKey}")
    String apiKey;

    @Autowired
    public GiphyGifService(GifClient gifClient) {
        this.gifClient = gifClient;
    }

    @Override
    public String getGifUrl(String tag) throws IOException {
        ResponseEntity<String> randomGifResponse;
        try {
            randomGifResponse = gifClient.retrieveRandomGif(this.apiKey, tag);
        } catch (FeignException e) {
            e.printStackTrace();
            throw new IOException("Can't retrieve random gif from Giphy.com");
        }

        JSONObject jsonBody;
        String embed_url;

        try {
            jsonBody = new JSONObject(randomGifResponse.getBody());
            embed_url = jsonBody.getJSONObject("data").getString("embed_url");
        } catch (JSONException e) {
            e.printStackTrace();
            throw new InvalidObjectException("Can't parse gif URL from Giphy json response");
        }


        return embed_url;
    }
}
