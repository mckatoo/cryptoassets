/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ikatoo.cryptoassets.services.binance;

import io.ikatoo.cryptoassets.config.Parameters;
import static io.ikatoo.cryptoassets.services.binance.ConsumeAPI._secret;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author mckatoo
 */
public class AccountService extends ConsumeAPI {

    private static AccountService instance;

    private static AccountService getInstance() {
        if (instance == null) {
            instance = new AccountService();
        }
        return instance;
    }

    public JSONObject getAccount(long recvWindow) throws Exception {

        JSONObject json = null;

        if (new RequestValidate().Validate(now, recvWindow)) {
            String query = "recvWindow=" + recvWindow + "&timestamp=" + now;
            String signature = "signature=" + ApiSecurity.encode(_secret, query);
            String url = "https://api.binance.com/api/v3/account?" + query + "&" + signature;
            json = new JSONObject(httpClientResponse(url));
        }

        return json;
    }

    public JSONArray getBalances(long recvWindow) throws Exception {
        return (JSONArray) getAccount(recvWindow).get("balances");
    }
    
    public JSONArray getTradeList(String symbol, long startTime, long endTime, long fromId, int limit, long recvWindow) throws IOException, InterruptedException, Exception {
        JSONArray json = null;

        symbol = symbol.equals("BTC") || symbol.equals("USDT") ? "symbol=BTCUSDT" : "symbol=" + symbol + "BTC";
        String stringStartTime = startTime == 0 ? "" : "&startTime=" + startTime;
        String stringEndTime = endTime == 0 ? "" : "&endTime=" + endTime;
        String stringFromId = fromId == 0 ? "" : "&fromId=" + fromId;
        String stringLimit = limit == 0 || limit > Parameters.getLimit() ? "&limit=" + Parameters.getLimit() : "&limit=" + limit;
        String stringRecvWindow = recvWindow == 0 || recvWindow < 10000 ? "" : "&recvWindow=" + recvWindow;
        
        String query = symbol + stringStartTime + stringEndTime + stringFromId + stringLimit + stringRecvWindow + "&timestamp=" + now;

        recvWindow = recvWindow == 0 ? Parameters.getRecvWindow() : recvWindow;
        if (new RequestValidate().Validate(now, recvWindow)) {
            String signature = "signature=" + ApiSecurity.encode(_secret, query);
            String url = "https://api.binance.com/api/v3/myTrades?" + query + "&" + signature;

            json = new JSONArray(httpClientResponse(url));
        }

        return json;
    }
    
    public JSONArray getTradeList(String symbol) throws InterruptedException, Exception{
        return getTradeList(symbol, 0, 0, 0, 0, 0);
    }

}
