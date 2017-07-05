package com.ai6.ikyrus.cabmodule.utils;

/**
 * Created by bharath on 7/5/17.
 */
public class UberOauthUtils {
    public static String generateCallBackUrl(String domainUrl, String userId){
        StringBuilder builder = new StringBuilder();
        builder.append("http://")
                .append(domainUrl)
                .append("/")
                .append("uber/callback/")
                .append(userId);
        return builder.toString();
    }
}
