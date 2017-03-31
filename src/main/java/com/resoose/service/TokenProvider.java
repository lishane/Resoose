package com.resoose.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by shane on 3/29/17.
 */

@Component
public class TokenProvider {

    private FusionToken fusionToken;
    private String clientId;
    private String clientSecret;
    public TokenProvider() {

        loadSecrets();

        String uri = "https://api.yelp.com/oauth2/token";

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "bearer");
        params.add("client_id", clientId);
        params.add("client_secret", clientSecret);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);
        RestTemplate restTemplate = new RestTemplate();

        fusionToken = restTemplate.postForObject(uri, request, FusionToken.class);
    }

    public String getToken() {
        return fusionToken.getAccess_token();
    }

    private void loadSecrets() {
        Properties prop = new Properties();
        InputStream input = null;

        try {
            input = new FileInputStream("secrets.properties");
            prop.load(input);
            clientId = prop.getProperty("client_id");
            clientSecret = prop.getProperty("client_secret");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
