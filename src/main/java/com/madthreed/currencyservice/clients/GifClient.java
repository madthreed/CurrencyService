package com.madthreed.currencyservice.clients;

import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface GifClient {
    ResponseEntity<?> retrieveRandomGif(String apiKey, String tag);
}
