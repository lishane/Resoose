package com.resoose.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shane on 3/29/17.
 */
@Component
public class TokenProvider {

    private FusionToken fusionToken;

    public TokenProvider() {
        String uri = "https://api.yelp.com/oauth2/token";
        String clientId = "mpaaez5Q2Y8L6wZ_-4kMqQ";
        String clientSecret = "iLLtiX9I1Uds7HhdPCbq93yZ25FmcbQ9Rlb0jS6Y3RHsJ8SHwjCLBDSCM7yiOZWr";

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
}
