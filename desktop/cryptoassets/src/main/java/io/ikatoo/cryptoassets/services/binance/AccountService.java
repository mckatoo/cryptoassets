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

}
