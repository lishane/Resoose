package com.resoose.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Random;

/**
 * Created by shane on 3/29/17.
 */


@Controller
public class BusinessFactory {

    public static final String searchUrl = "https://api.yelp.com/v3/businesses/search";

    @Autowired
    private TokenProvider tokenProvider;

    private HttpEntity<String> prepareHttpEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Bearer " + tokenProvider.getToken());

        return new HttpEntity<>(headers);

    }
    public FusionBusiness getRandomRestaurant(String term, String longitude, String latitude, String price) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(searchUrl)
                .queryParam("term", term)
                .queryParam("longitude", longitude)
                .queryParam("latitude", latitude)
                .queryParam("price", price);

        RestTemplate restTemplate = new RestTemplate();
        System.out.println(builder.buildAndExpand().toUri());
        ResponseEntity<FusionSearch> response;
        try {
            response = restTemplate.exchange(builder.buildAndExpand().toUri(), HttpMethod.GET, prepareHttpEntity(), FusionSearch.class);
        } catch (Exception e) {
            tokenProvider.refreshToken();
            response = restTemplate.exchange(builder.buildAndExpand().toUri(), HttpMethod.GET, prepareHttpEntity(), FusionSearch.class);
        }
        FusionSearch fusionSearch = response.getBody();

        Random random = new Random();
        int generateNumber = random.nextInt(fusionSearch.getBusinesses().size());
        return fusionSearch.getBusinesses().get(generateNumber);
    }

    public String getFusionToken() {
        return tokenProvider.getToken();
    }

}
