/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ikatoo.cryptoassets;

import io.ikatoo.cryptoassets.config.UserDataAPI;
import io.ikatoo.cryptoassets.interfaces.FrmSplashScreen;
import io.ikatoo.cryptoassets.models.Order;
import io.ikatoo.cryptoassets.services.binance.ConsumeAPI;
import io.ikatoo.cryptoassets.services.binance.MarketDataService;
import io.ikatoo.cryptoassets.services.binance.OrdersService;
import java.io.IOException;
import java.math.BigDecimal;

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
    
    public static void main(String[] args) throws IOException, Exception {
//        FrmSplashScreen splash = new FrmSplashScreen();
//        splash.setVisible(true);
//        FrmMain frmmain = new FrmMain();
//        FormManager.openForm(frmmain);
        ConsumeAPI._secret = UserDataAPI.getSecretKey();
        
//        ESPAÇO RESERVADO PARA TESTAR SERVICES
//        System.out.println(new GeneralService().getExchangeInfo());
//        System.out.println(new MarketDataService().getOrderBook("BTC",100));
//        System.out.println(new MarketDataService().getOrderBook("BTC"));
//        System.out.println(new MarketDataService().getRecentTradesList("BTC",100));
//        System.out.println(new MarketDataService().getRecentTradesList("BTC"));
//        System.out.println(new MarketDataService().getOldTradeLookup("BTC",100));
//        System.out.println(new MarketDataService().getOldTradeLookup("BTC"));
//        System.out.println(new MarketDataService().getCompressedAggregateTradesList("BTC",0,0,0,0));
//        System.out.println(new MarketDataService().getCompressedAggregateTradesList("BTC"));
//        System.out.println(new OrdersService().getAllOrders("BNB", 0, 0, 0, 0, 0));
//        System.out.println(new OrdersService().getAllOrders("BNB"));
//        System.out.println(new MarketDataService().getKlineCandlestickData("BNB", "1w", 0, 0, 0));
//        System.out.println(new MarketDataService().getKlineCandlestickData("ETH", "1h"));
//        System.out.println(new MarketDataService().getCurrentAveragePrice("AION"));
//        System.out.println(new MarketDataService().get24hrTickerPriceChangeStatistics("AION"));
//        System.out.println(new MarketDataService().get24hrTickerPriceChangeStatistics());
//        System.out.println(new MarketDataService().getSymbolPriceTicker("AION").get("price"));
//        System.out.println(new MarketDataService().getSymbolPriceTicker());
//        System.out.println(new MarketDataService().getSymbolOrderBookTicker("AION"));
//        System.out.println(new MarketDataService().getSymbolOrderBookTicker());
        System.out.println(new OrdersService().postNewOrderLimit("ETH", "BUY", "GTC", new BigDecimal("0.030"), new BigDecimal("0.030"), 0));

//        ESPAÇO RESERVADO PARA TESTAR SERVICES
    }
}
