package com.madthreed.currencyservice.models;

import java.util.Date;
import java.util.Map;
import lombok.Data;

@Data
public class OpenExchangeRateHistoricalBean {
    private String disclaimer;
    private String license;
    private Date timestamp;
    private String base;
    private Map<String,Double> rates;
}
