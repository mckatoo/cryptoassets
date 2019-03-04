/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ikatoo.cryptoassets.services;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author mckatoo
 */
public class OrdersService extends ConsumeAPI {

    private static OrdersService instance;

    private static OrdersService getInstance() {
        if (instance == null) {
            instance = new OrdersService();
        }
        return instance;
    }

    public JSONArray getAllOrders(String symbol, long orderId, long startTime, long endTime, int limit, long recvWindow) throws Exception {

        JSONArray json = null;

        if (new RequestValidate().Validate(now, recvWindow)) {
            String query = "symbol=" + symbol + "&orderId=" + orderId + "&startTime=" + startTime + "&endTime=" + endTime + "&limit=" + limit + "&recvWindow=" + recvWindow + "&timestamp=" + now;
            String signature = "signature=" + ApiSecurity.encode(_secret, query);
            String url = "https://api.binance.com/api/v3/allOrders?" + query + "&" + signature;

            json = new JSONArray(httpClientResponse(url));
        }

        return json;
    }

    public JSONArray getAllOrders(String symbol, long startTime, long endTime, int limit, long recvWindow) throws Exception {
        long orderId = 0;
        return getAllOrders(symbol, orderId, startTime, endTime, limit, recvWindow);
    }

    public JSONArray getAllOrders(String symbol, long endTime, int limit, long recvWindow) throws Exception {
        long startTime = 0;
        return getAllOrders(symbol, startTime, endTime, limit, recvWindow);
    }

    public JSONArray getAllOrders(String symbol, int limit, long recvWindow) throws Exception {
        long endTime = 0;
        return getAllOrders(symbol, endTime, limit, recvWindow);
    }

    public JSONArray getAllOrders(String symbol, long recvWindow) throws Exception {
        int limit = 500;
        return getAllOrders(symbol, limit, recvWindow);
    }

    public JSONArray getAllOrders(String symbol) throws Exception {
        long recvWindow = 5000;
        return getAllOrders(symbol, recvWindow);
    }

    public JSONObject getOpenOrders(String symbol, long recvWindow) throws Exception {

        JSONObject json = null;

        if (new RequestValidate().Validate(now, recvWindow)) {
            String query = "symbol=" + symbol + "&recvWindow=" + recvWindow + "&timestamp=" + now;
            String signature = "signature=" + ApiSecurity.encode(_secret, query);
            String url = "https://api.binance.com/api/v3/openOrders?" + query + "&" + signature;

            json = new JSONObject(httpClientResponse(url));
        }

        return json;
    }

}
