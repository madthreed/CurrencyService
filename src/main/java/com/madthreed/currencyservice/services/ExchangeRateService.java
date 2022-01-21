package com.madthreed.currencyservice.services;

import java.io.IOException;

public interface ExchangeRateService {
    int getCompareForCurrencyCode(String code) throws IOException;
}
