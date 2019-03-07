/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ikatoo.cryptoassets;

import io.ikatoo.cryptoassets.config.UserDataAPI;
import io.ikatoo.cryptoassets.interfaces.FrmMain;
import io.ikatoo.cryptoassets.services.binance.ConsumeAPI;
import io.ikatoo.cryptoassets.services.binance.MarketDataService;
import io.ikatoo.cryptoassets.uteis.FormManager;
import java.beans.PropertyVetoException;
import java.io.IOException;

/**
 *
 * @author mckatoo
 */
public class CryptoAssets {
    
    private static CryptoAssets instance;
    
    private static CryptoAssets getInstance() {
        if (instance == null) {
            instance = new CryptoAssets();
        }
        return instance;
    }
    
    public static void main(String[] args) throws PropertyVetoException, IOException {
        FrmMain frmmain = new FrmMain();
        FormManager.openForm(frmmain);
        ConsumeAPI._secret = UserDataAPI.getSecretKey();
        
        ////// TESTAR REQUISIÇÕES DE SERVIÇOS ENTRE ESTE TRECHO
//        MarketDataService mk = new MarketDataService();
//        System.out.println(mk.getOrderBook("BTC", 5));
        ////// TESTAR REQUISIÇÕES DE SERVIÇOS ENTRE ESTE TRECHO
    }
}
