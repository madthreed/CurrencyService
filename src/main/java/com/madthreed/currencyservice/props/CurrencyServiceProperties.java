package com.madthreed.currencyservice.props;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "currencyservice")
@Configuration
@Data
public class CurrencyServiceProperties {
    private String OERApiKey;
    private String GiphyApiKey;
    private String baseCurrency;
    private String httpEndpoint;
}
