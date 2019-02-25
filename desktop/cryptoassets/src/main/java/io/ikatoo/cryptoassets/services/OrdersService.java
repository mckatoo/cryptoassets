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
    
     
//    public JSONObject getAllOrders(String symbol,long orderId,long startTime,long endTime,int limit,long recvWindow,long timestamp) throws Exception {
    public JSONArray getAllOrders(String symbol,long orderId,long startTime,long endTime,int limit,long recvWindow,long timestamp) throws Exception {
        String query = "symbol="+symbol+"&orderId="+orderId+"&startTime="+startTime+"&endTime="+endTime+"&limit="+limit+"&recvWindow="+recvWindow+"&timestamp="+timestamp;
        String signature = "signature="+ApiSecurity.encode(_secret, query); //4a6d37d4301ed5faaee681ab9d1549dcc85655c6489cbf3d7f90628917a95526
        String url = "https://api.binance.com/api/v3/allOrders?" + query + "&" + signature;
        
        JSONArray json = new JSONArray(httpClientResponse(url));
        return json;
    }
    
    public JSONObject getOpenOrders(String symbol, long recWindow,long timestamp) throws Exception {
        String query = "symbol="+symbol+"&recvWindow="+recWindow+"&timestamp="+timestamp;
        String signature = "signature="+ApiSecurity.encode(_secret, query);
        String url = "https://api.binance.com/api/v3/openOrders?" + query + "&" + signature;
        
        JSONObject json = new JSONObject(httpClientResponse(url));
        
        return json;
    }
    
}
