/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ikatoo.cryptoassets.services.binance;

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

    public long orderId;
    public long startTime;
    public long endTime;
    public int limit;
    public long recvWindow;

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setRecvWindow(long recvWindow) {
        this.recvWindow = recvWindow;
    }

    public JSONArray getAllOrders(String symbol) throws Exception {

        JSONArray json = null;
        
        symbol = symbol.equals("BTC") || symbol.equals("USDT") ? "BTCUSDT" : symbol + "BTC";

        if (new RequestValidate().Validate(now, recvWindow)) {
            String query = "symbol=" + symbol + 
                    "&orderId=" + orderId + 
                    "&startTime=" + startTime + 
                    "&endTime=" + endTime + 
                    "&limit=" + limit + 
                    "&recvWindow=" + recvWindow + 
                    "&timestamp=" + now;
            String signature = "signature=" + ApiSecurity.encode(_secret, query);
            String url = "https://api.binance.com/api/v3/allOrders?" + query + "&" + signature;

            json = new JSONArray(httpClientResponse(url));
        }

        return json;
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
