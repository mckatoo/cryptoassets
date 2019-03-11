/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ikatoo.cryptoassets.services.binance;

import java.io.IOException;
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
            connected = getResponse("https://api.binance.com/api/v1/ping").statusCode() == 200;
        } catch (IOException | InterruptedException e) {
            System.out.println(e);
        }
        return connected;
    }

    public Long serverTime() throws IOException, InterruptedException {
        JSONObject jsonServerTime = new JSONObject(httpClientResponse("https://api.binance.com/api/v1/time"));
        return Long.parseLong(jsonServerTime.get("serverTime").toString());
    }

    public JSONObject getExchangeInfo() throws IOException, InterruptedException {
        JSONObject exchangeInfo = new JSONObject(httpClientResponse("https://api.binance.com/api/v1/exchangeInfo"));
        return exchangeInfo;
    }
    
}
