/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ikatoo.cryptoassets;

import io.ikatoo.cryptoassets.interfaces.FrmSplashScreen;
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
    
    public static void main(String[] args) throws IOException, Exception {
        FrmSplashScreen splash = new FrmSplashScreen();
        splash.setVisible(true);
//        FrmMain frmmain = new FrmMain();
//        FormManager.openForm(frmmain);
//        ConsumeAPI._secret = UserDataAPI.getSecretKey();
        
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
//        System.out.println(new MarketDataService().getKlineCandlestickData("BNB", "1h"));
//        System.out.println(new MarketDataService().getKlineCandlestickData("ETH", "1h"));
//        System.out.println(new MarketDataService().getCurrentAveragePrice("AION"));
//        System.out.println(new MarketDataService().get24hrTickerPriceChangeStatistics("AION"));
//        System.out.println(new MarketDataService().get24hrTickerPriceChangeStatistics());
//        System.out.println(new MarketDataService().getSymbolPriceTicker("AION").get("price"));
//        System.out.println(new MarketDataService().getSymbolPriceTicker());
//        System.out.println(new MarketDataService().getSymbolOrderBookTicker("AION"));
//        System.out.println(new MarketDataService().getSymbolOrderBookTicker());
//        System.out.println(new OrdersService().postNewOrderLimit("AION", "SELL", "GTC", new BigDecimal("35"), new BigDecimal("0.0000373"), 0));
//        System.out.println(new OrdersService().postNewOrderStopLoss("AION", "SELL", new BigDecimal("35"), new BigDecimal("0.0000337"), 0));
//        System.out.println(new OrdersService().postNewOrderStopLossLimit("XMR", "SELL", "GTC", new BigDecimal("0.092"), new BigDecimal("0.012611"), new BigDecimal("0.012607"), 0));
//        System.out.println(new OrdersService().postNewOrderStopLossLimit("AION", "SELL", "GTC", new BigDecimal("35"), new BigDecimal("0.0000337"), new BigDecimal("0.0000335"), 0));
//        System.out.println(new OrdersService().deleteCancelOrder("AION", 300915339, "gviZUM7UlSVXlPzcZs26p7", "gviZUM7UlSVXlPzcZs26p7", 100000));
//        System.out.println(new OrdersService().getOrder("XMR", 63784696, "", 0));
//        System.out.println(new OrdersService().getOpenOrders(0));
//        System.out.println(new AccountService().getTradeList("AION", 0, 0, 0, 0, 0));
//        System.out.println(new AccountService().getTradeList("AION"));

//        ESPAÇO RESERVADO PARA TESTAR SERVICES
    }
}
