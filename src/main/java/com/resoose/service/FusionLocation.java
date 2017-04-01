package com.resoose.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by shane on 4/1/17.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class FusionLocation {

    private String city;
    private String country;
    private String address1;
    private String state;
    private String zip_code;

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getAddress1() {
        return address1;
    }

    public String getState() {
        return state;
    }

    public String getZip_code() {
        return zip_code;
    }
}
