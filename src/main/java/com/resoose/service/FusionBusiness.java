package com.resoose.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by shane on 3/29/17.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class FusionBusiness {

    private String name;
    private String phone;
    private String price;
    private double rating;
    private int review_count;
    private String url;

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

    public int getReview_count() {
        return review_count;
    }

    public String getUrl() {
        return url;
    }
}
