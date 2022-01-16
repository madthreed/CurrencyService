package com.madthreed.currencyservice.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class GiphyGifService implements GifService{
    @Override
    public ResponseEntity<Map> getGif(String tag) {
        return null;
    }
}
