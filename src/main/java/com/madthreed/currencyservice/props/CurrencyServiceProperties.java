package com.madthreed.currencyservice.props;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "currencyservice")
@Configuration

public class CurrencyServiceProperties {
    private String oerApiToken;
    private String baseCurrency;
    private String httpEndpoint;

    public CurrencyServiceProperties() {
    }

    public CurrencyServiceProperties(String oerApiToken, String baseCurrency, String httpEndpoint) {
        this.oerApiToken = oerApiToken;
        this.baseCurrency = baseCurrency;
        this.httpEndpoint = httpEndpoint;
    }

    public String getOerApiToken() {
        return oerApiToken;
    }

    public void setOerApiToken(String oerApiToken) {
        this.oerApiToken = oerApiToken;
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
