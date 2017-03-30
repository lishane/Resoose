package com.resoose.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

/**
 * Created by shane on 3/29/17.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class FusionSearch {

    private ArrayList<FusionBusiness> businesses;

    public ArrayList<FusionBusiness> getBusinesses() {
        return businesses;
    }
}
