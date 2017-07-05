package com.ai6.ikyrus.cabmodule.utils;

import com.uber.sdk.rides.client.SessionConfiguration;

/**
 * Created by bharath on 7/5/17.
 */
public class EnvResolver {
    public static SessionConfiguration.Environment uberEnvironment(String env){
        SessionConfiguration.Environment environment = SessionConfiguration.Environment.SANDBOX;

        if(env.equalsIgnoreCase("dev")){
            //TODO
        }
        return environment;
    }
}
