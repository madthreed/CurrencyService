package com.madthreed.currencyservice.clients;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface GifClient {
    ResponseEntity<Map> retrieveRandomGif(String apiKey, String tag);
}
