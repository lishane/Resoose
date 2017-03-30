package com.resoose.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

/**
 * Created by shane on 3/29/17.
 */


@Controller
public class BusinessFactory {

    public static final String searchUrl = "https://api.yelp.com/v3/businesses/search?term=food&limit=10&latitude=37.786882&longitude=-122.399972&radius=";

    @Autowired
    private TokenProvider tokenProvider;

    private HttpEntity<String> prepareHttpEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Bearer " + tokenProvider.getToken());

        return new HttpEntity<>(headers);

    }
    public FusionBusiness getRandomRestaurant() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<FusionSearch> response =  restTemplate.exchange(searchUrl, HttpMethod.GET, prepareHttpEntity(), FusionSearch.class);
        FusionSearch fusionSearch = response.getBody();

        return fusionSearch.getBusinesses().get(0);
    }

    public String getFusionToken() {
        return tokenProvider.getToken();
    }

}
