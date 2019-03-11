/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ikatoo.cryptoassets.services.binance;

import io.ikatoo.cryptoassets.config.Parameters;
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

    public JSONArray getAllOrders(String symbol,long orderId, long startTime, long endTime, int limit, long recvWindow) throws Exception {

        JSONArray json = null;
        
        symbol = symbol.equals("BTC") || symbol.equals("USDT") ? "symbol=BTCUSDT" : "symbol=" + symbol + "BTC";
        String stringOrderId = orderId == 0 ? "" : "&orderId=" + orderId;
        String stringStartTime = startTime == 0 ? "" : "&startTime=" + startTime;
        String stringEndTime = endTime == 0 ? "" : "&endTime=" + endTime;
        String stringLimit = limit == 0 || limit > 1000 ? "" : "&limit=" + limit;
        String stringRecvWindow = recvWindow == 0 || recvWindow < 10000 ? "" : "&recvWindow=" + recvWindow;
        String query = symbol + stringOrderId + stringStartTime + stringEndTime + stringLimit + stringRecvWindow + "&timestamp=" + now;

        recvWindow = recvWindow == 0 ? Parameters.getRecvWindow() : recvWindow;
        if (new RequestValidate().Validate(now, recvWindow)) {
            String signature = "signature=" + ApiSecurity.encode(_secret, query);
            String url = "https://api.binance.com/api/v3/allOrders?" + query + "&" + signature;

            json = new JSONArray(httpClientResponse(url));
        }

        return json;
    }
    
    public JSONArray getAllOrders(String symbol) throws Exception{
        return getAllOrders(symbol, 0, 0, 0, 0, 0);
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
