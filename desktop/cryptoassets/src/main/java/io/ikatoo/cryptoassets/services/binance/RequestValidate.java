/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ikatoo.cryptoassets.services.binance;

import java.io.IOException;

/**
 *
 * @author mckatoo
 */
public class RequestValidate extends GeneralService {

    public Boolean Validate(Long timestamp, Long recvWindow) throws IOException, InterruptedException{
        Long serverTime = serverTime();
        return ((timestamp < (serverTime + 1000)) && ((serverTime - timestamp) <= recvWindow));
    }
    
}
