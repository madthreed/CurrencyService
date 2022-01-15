package com.madthreed.currencyservice.models;

import java.util.Date;
import java.util.Map;
import lombok.Data;

public class OpenExchangeRateHistoricalBean {
    private String disclaimer;
    private String license;
    private Date timestamp;
    private String base;
    private Map<String,Double> rates;

    public OpenExchangeRateHistoricalBean() {
    }

    public OpenExchangeRateHistoricalBean(String disclaimer, String license, Date timestamp, String base, Map<String, Double> rates) {
        this.disclaimer = disclaimer;
        this.license = license;
        this.timestamp = timestamp;
        this.base = base;
        this.rates = rates;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }
}
