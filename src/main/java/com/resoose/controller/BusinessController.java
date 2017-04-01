package com.resoose.controller;

import com.resoose.service.BusinessFactory;
import com.resoose.service.FusionBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by shane on 3/29/17.
 */

@RestController
@RequestMapping(path = "/business")
public class BusinessController {

    @Autowired
    private BusinessFactory businessFactory;

    @RequestMapping(path = "/random")
    public FusionBusiness getRandomBusiness(@RequestParam String term, @RequestParam String longitude, @RequestParam String latitude, @RequestParam String price) {
        return businessFactory.getRandomRestaurant(term, longitude, latitude, price);
    }
}
