package com.resoose.controller;

import com.resoose.service.BusinessFactory;
import com.resoose.service.FusionBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public FusionBusiness getRandomBusiness() {
        return businessFactory.getRandomRestaurant();
    }

    @RequestMapping(path = "/token")
    public String getToken() {
        return businessFactory.getFusionToken();
    }
}
