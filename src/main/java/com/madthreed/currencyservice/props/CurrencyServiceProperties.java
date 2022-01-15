package com.madthreed.currencyservice.props;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "currencyservice")
@Configuration

public class CurrencyServiceProperties {
    private String OERApiKey;
    private String GiphyApiKey;
    private String baseCurrency;
    private String httpEndpoint;

    public CurrencyServiceProperties() {
    }

    public CurrencyServiceProperties(String OERApiKey, String giphyApiKey, String baseCurrency, String httpEndpoint) {
        this.OERApiKey = OERApiKey;
        GiphyApiKey = giphyApiKey;
        this.baseCurrency = baseCurrency;
        this.httpEndpoint = httpEndpoint;
    }

    public String getOERApiKey() {
        return OERApiKey;
    }

    public void setOERApiKey(String OERApiKey) {
        this.OERApiKey = OERApiKey;
    }

    public String getGiphyApiKey() {
        return GiphyApiKey;
    }

    public void setGiphyApiKey(String giphyApiKey) {
        GiphyApiKey = giphyApiKey;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public String getHttpEndpoint() {
        return httpEndpoint;
    }

    public void setHttpEndpoint(String httpEndpoint) {
        this.httpEndpoint = httpEndpoint;
    }
}
