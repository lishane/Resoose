package com.resoose.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

/**
 * Created by shane on 3/29/17.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class FusionToken {

    private String access_token;
    private String token_type;

    public String getAccess_token() {
        return access_token;
    }

    public String getToken_type() {
        return token_type;
    }
}
