/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ikatoo.cryptoassets.services;

import org.apache.http.HttpResponse;
import org.json.JSONObject;

/**
 *
 * @author mckatoo
 */
public class GeneralService extends ConsumeAPI {

    private static GeneralService instance;

    private static GeneralService getInstance() {
        if (instance == null) {
            instance = new GeneralService();
        }
        return instance;
    }

    public boolean ping() {
        boolean connected = false;
        try {
            connected = getResponse("https://api.binance.com/api/v1/ping").getStatusLine().getStatusCode() == 200;
        } catch (Exception e) {
            System.out.println(e);
        }
        return connected;
    }

    public Long serverTime() {
        JSONObject jsonServerTime = new JSONObject(httpClientResponse("https://api.binance.com/api/v1/time"));
        return Long.parseLong(jsonServerTime.get("serverTime").toString());
    }

}
