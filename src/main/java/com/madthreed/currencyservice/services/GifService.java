package com.madthreed.currencyservice.services;

import com.madthreed.currencyservice.models.giphy.Giphy;

import java.util.Map;

public interface GifService {
   Giphy getGif(String tag);
}
