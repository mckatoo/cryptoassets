/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ikatoo.cryptoassets;

import io.ikatoo.cryptoassets.config.UserDataAPI;
import io.ikatoo.cryptoassets.interfaces.FrmMain;
import io.ikatoo.cryptoassets.interfaces.FrmSplashScreen;
import io.ikatoo.cryptoassets.services.binance.ConsumeAPI;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 *
 * @author mckatoo
 */
public class CryptoAssets {

    private static CryptoAssets instance;

    private static final ExecutorService executorService = Executors.newFixedThreadPool(4);

    private static CryptoAssets getInstance() {
        if (instance == null) {
            instance = new CryptoAssets();
        }
        return instance;
    }

    public static void main(String[] args) throws IOException, Exception {

        FrmSplashScreen splash = new FrmSplashScreen();

        Future<Void> future = executorService.submit(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                FrmMain frmmain = new FrmMain();
                splash.lbInfo.setText("Configurando informações de acesso a Exchange");
                ConsumeAPI._secret = UserDataAPI.getSecretKey();
                splash.lbInfo.setText("Iniciando...");
//                FormManager.openForm(frmmain);
                return null;
            }
        });

        splash.setVisible(true);

        try {
            future.get(60, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            System.out.println(e);
        } finally {
            splash.dispose();
            executorService.shutdown();
        }

//        --------------------------------------------------------------------
//        FrmMain frmmain = new FrmMain();
//        FormManager.openForm(frmmain);
//        ConsumeAPI._secret = UserDataAPI.getSecretKey();
//        ESPAÇO RESERVADO PARA TESTAR SERVICES
//        System.out.println(new GeneralService().getExchangeInfo());
//        System.out.println(new GeneralService().getAvailableSimbolsForTrade());
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
//        System.out.println(new MarketDataService().getKlineCandlestickData("ETH", "1h").getJSONArray(499).length());
//        JSONArray jArray = new MarketDataService().getKlineCandlestickData("ETH", "1h");
//        System.out.println(jArray);
//        ESPAÇO RESERVADO PARA TESTAR SERVICES
    }
}
