package com.ai6.ikyrus.cabmodule.uber;

import com.ai6.ikyrus.cabmodule.config.Configuration;
import com.ai6.ikyrus.cabmodule.utils.EnvResolver;
import com.ai6.ikyrus.cabmodule.utils.UberOauthUtils;
import com.google.api.client.auth.oauth2.Credential;
import com.uber.sdk.core.auth.Scope;
import com.uber.sdk.rides.auth.OAuth2Credentials;
import com.uber.sdk.rides.client.CredentialsSession;
import com.uber.sdk.rides.client.ServerTokenSession;
import com.uber.sdk.rides.client.SessionConfiguration;
import com.uber.sdk.rides.client.UberRidesApi;
import com.uber.sdk.rides.client.model.UserProfile;
import com.uber.sdk.rides.client.services.RidesService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * Created by bharath on 7/5/17.
 */
@Component
@Data
public class UberAuthentication {
    @Autowired
    private Configuration configuration;
    private ServerTokenSession serverTokenSession;
    private SessionConfiguration sessionConfiguration;
    private SessionConfiguration.Environment environment;
    private  OAuth2Credentials credentials;


    public UberAuthentication(Configuration configuration) {
        this.environment = EnvResolver.uberEnvironment(configuration.getEnvironment());
        this.configuration = configuration;
        SessionConfiguration.Environment env = EnvResolver
                .uberEnvironment(configuration.getEnvironment());
        sessionConfiguration = new SessionConfiguration.Builder().
                setClientId(configuration.getUberClientId())
                .setEnvironment(env)
                .setServerToken(configuration.getUberTokenId()).build();
        this.serverTokenSession = new ServerTokenSession(sessionConfiguration);
    }

    public String oauth(String userId) throws UnsupportedEncodingException {

        UberOauthUtils.generateCallBackUrl(configuration.getDomainUrl(), userId);
        SessionConfiguration config = new SessionConfiguration.Builder()
                .setClientId(configuration.getUberClientId())
                .setClientSecret(configuration.getUberTokenId())
                .setEnvironment(environment)
                .setScopes(Arrays.asList(Scope.PROFILE, Scope.REQUEST))
                .setRedirectUri(UberOauthUtils.generateCallBackUrl(configuration.getDomainUrl(), userId))
                .build();

        credentials = new OAuth2Credentials.Builder()
                .setSessionConfiguration(config)
                .build();
        return credentials.getAuthorizationUrl();
    }

    public String normalAuth() {
        SessionConfiguration.Environment env = EnvResolver
                .uberEnvironment(configuration.getEnvironment());
        sessionConfiguration = new SessionConfiguration.Builder().
                setClientId(configuration.getUberClientId())
                .setEnvironment(env)
                .setClientSecret(configuration.getUberTokenId()).build();
        this.serverTokenSession = new ServerTokenSession(this.sessionConfiguration);
        return null;
    }

    public retrofit2.Response<UserProfile> redirectURI(String userId, String token) throws IOException {
        Credential credential = credentials.authenticate(token, userId);
        CredentialsSession session = new CredentialsSession(sessionConfiguration, credential);
        RidesService service = UberRidesApi.with(session).build().createService();
        retrofit2.Response<UserProfile> response = service.getUserProfile().execute();
        return response;
    }

}
