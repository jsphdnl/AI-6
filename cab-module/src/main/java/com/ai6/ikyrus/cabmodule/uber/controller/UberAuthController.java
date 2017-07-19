package com.ai6.ikyrus.cabmodule.uber.controller;

import com.ai6.ikyrus.cabmodule.uber.UberAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

/**
 * Created by bharath on 7/5/17.
 */
@RestController
@RequestMapping("/uber")
public class UberAuthController {

    @Autowired
    private UberAuthentication uberAuthentication;


    @RequestMapping("/callback/{userId}")
    public void oauthCallBack(@PathVariable String userId, @RequestParam("code") String authToken) throws IOException {
        uberAuthentication.redirectURI(userId, authToken);
    }

    @RequestMapping("/oauth")
    public String oauthLogin() throws UnsupportedEncodingException {
        String uuid = UUID.randomUUID().toString();
        return uberAuthentication.oauth(uuid);
    }
}
