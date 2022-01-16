package com.madthreed.currencyservice.services;

import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface GifService {
   ResponseEntity<?> getGif(String tag);
}
