/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ikatoo.cryptoassets.services.binance;

import java.io.IOException;
import org.json.JSONArray;
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

    public JSONArray getAvailableSimbolsForTrade() throws IOException, InterruptedException {
        JSONObject exchangeInfo = new JSONObject(httpClientResponse("https://api.binance.com/api/v1/exchangeInfo"));
        JSONArray symbols = exchangeInfo.getJSONArray("symbols");
        JSONArray assets = new JSONArray("[BTC]");
        for (int i = 0; i < symbols.length(); i++) {
            String basedAsset, quoteAsset, status;
            basedAsset = symbols.getJSONObject(i).get("baseAsset").toString();
            quoteAsset = symbols.getJSONObject(i).get("quoteAsset").toString();
            status = symbols.getJSONObject(i).get("status").toString();
            if ((status.equals("TRADING")) && (quoteAsset.equals("BTC"))) {
                assets.put(basedAsset);
            }
        }

        return assets;
    }

}
