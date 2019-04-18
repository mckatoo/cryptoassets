/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ikatoo.cryptoassets.interfaces.chart.candlestick;

import io.ikatoo.cryptoassets.interfaces.chart.candlestick.model.Trade;
import io.ikatoo.cryptoassets.services.binance.MarketDataService;
import io.ikatoo.cryptoassets.uteis.TimeUtils;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;

/**
 *
 * @author mckatoo
 */
public class FxMarketPxFeeder {

    private JfreeCandlestickChart jfreeCandlestickChart;
    private ExecutorService executorService;
    private String asset;
    private String interval;

    public FxMarketPxFeeder(JfreeCandlestickChart jfreeCandlestickChart, String interval, String asset) {
        super();
        this.executorService = Executors.newCachedThreadPool();
        this.jfreeCandlestickChart = jfreeCandlestickChart;
        this.interval = interval;
        this.asset = asset;
    }

    public void run() {
        executorService.execute(() -> {
            try {
                read();
            } catch (InterruptedException | IOException ex) {
                Logger.getLogger(FxMarketPxFeeder.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    private void read() throws InterruptedException, IOException {
        jfreeCandlestickChart.historyTrade(asset, interval);
        MarketDataService marketDataService = new MarketDataService();
        while (true) {
            Thread.sleep(1000);
            long now = new Date().getTime();
            long start = now - TimeUtils.convertIntervalToMilliseconds(interval);
            JSONArray jsonArray = marketDataService.getKlineCandlestickData(asset, interval, start, now, 1).getJSONArray(0);
            Double price = marketDataService.getSymbolPriceTicker(asset).getDouble("price");
            Double volume = marketDataService.get24hrTickerPriceChangeStatistics(asset).getDouble("volume");
//            Double volume = jsonArray.getDouble(5);
            System.out.println(volume);
            Trade t = new Trade(
                    new Date().getTime(),
                    price,
                    volume);
            jfreeCandlestickChart.onTrade(t);
        }
    }

}
