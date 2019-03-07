/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ikatoo.cryptoassets.services.binance;

import io.ikatoo.cryptoassets.config.Parameters;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author mckatoo
 */
public class MarketDataService extends ConsumeAPI {

    private static MarketDataService instance;

    private static MarketDataService getInstance() {
        if (instance == null) {
            instance = new MarketDataService();
        }
        return instance;
    }

    public JSONArray getOrderBook(String symbol, int limit) throws IOException {

        symbol = symbol.equals("BTC") || symbol.equals("USDT") ? "BTCUSDT" : symbol + "BTC";
        String query = "symbol=" + symbol + "&limit=" + limit;
        String url = "https://api.binance.com/api/v1/trades?" + query;

        JSONArray json = new JSONArray(httpClientResponse(url));

        return json;
    }

    public JSONObject getOrderBook(String symbol) throws IOException {
        return (JSONObject) getOrderBook(symbol, 1).get(0);
    }

}
