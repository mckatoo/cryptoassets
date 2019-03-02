/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ikatoo.cryptoassets.services;

import org.apache.http.HttpResponse;

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
            HttpResponse response = getResponse("https://api.binance.com/api/v1/ping");
            if (response.getStatusLine().getStatusCode() == 200) {
                connected = true;
            }
        } catch (Exception e) {
            System.out.println(e);
            connected = false;
        }
        return connected;
    }

}
