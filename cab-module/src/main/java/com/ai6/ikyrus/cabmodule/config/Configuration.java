package com.ai6.ikyrus.cabmodule.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by bharath on 7/5/17.
 */
@Data
@NoArgsConstructor
@Component
@ConfigurationProperties
public class Configuration {
    @Value("${uber.clientId}")
    private String uberClientId;
    @Value("${uber.serverToken}")
    private String uberTokenId;
    @Value("${uber.environment}")
    private String environment;
    @Value("${uber.callback}")
    private String domainUrl;
}
