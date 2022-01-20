package com.madthreed.currencyservice.clients;

import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.Set;

public interface GifClient {
    ResponseEntity<String> retrieveRandomGif(String apiKey, String tag);
}
