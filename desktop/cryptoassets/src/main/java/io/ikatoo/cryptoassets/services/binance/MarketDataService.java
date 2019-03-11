/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ikatoo.cryptoassets.services.binance;

import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author mckatoo
 */
public class MarketDataService extends ConsumeAPI {
    
    private static MarketDataService instance;
    
    private static MarketDataService getInstance() {
        
        if (instance == null) {
            instance = new MarketDataService();
        }
        return instance;
    }
    
    public JSONObject getOrderBook(String symbol, int limit) throws IOException, InterruptedException {
        
        symbol = symbol.equals("BTC") || symbol.equals("USDT") ? "BTCUSDT" : symbol + "BTC";
        String query = "symbol=" + symbol + "&limit=" + limit;
        String url = "https://api.binance.com/api/v1/depth?" + query;
        
        JSONObject json = new JSONObject(httpClientResponse(url));
        
        return json;
    }
    
    public JSONObject getOrderBook(String symbol) throws IOException, InterruptedException {
        
        return getOrderBook(symbol, 100);
        
    }
    
    public JSONArray getRecentTradesList(String symbol, int limit) throws IOException, InterruptedException {
        
        symbol = symbol.equals("BTC") || symbol.equals("USDT") ? "BTCUSDT" : symbol + "BTC";
        String query = "symbol=" + symbol + "&limit=" + limit;
        String url = "https://api.binance.com/api/v1/trades?" + query;
        
        return new JSONArray(httpClientResponse(url));
        
    }
    
    public JSONArray getRecentTradesList(String symbol) throws IOException, InterruptedException {
        
        return getRecentTradesList(symbol, 500);
        
    }
    
    public JSONArray getOldTradeLookup(String symbol, int limit) throws IOException, InterruptedException {
        
        symbol = symbol.equals("BTC") || symbol.equals("USDT") ? "BTCUSDT" : symbol + "BTC";
        String query = "symbol=" + symbol + "&limit=" + limit;
        String url = "https://api.binance.com/api/v1/historicalTrades?" + query;
        
        return new JSONArray(httpClientResponse(url));
        
    }
    
    public JSONArray getOldTradeLookup(String symbol) throws IOException, InterruptedException {
        return getOldTradeLookup(symbol, 500);
    }
    
    public JSONArray getCompressedAggregateTradesList(String symbol, long fromId, long startTime, long endTime, int limit) throws IOException, InterruptedException {
        
        symbol = symbol.equals("BTC") || symbol.equals("USDT") ? "symbol=BTCUSDT" : symbol + "BTC";
        String stringFromId = fromId == 0 ? "" : "&fromId=" + fromId;
        String stringStartTime = startTime == 0 ? "" : "&startTime=" + startTime;
        String stringEndTime = endTime == 0 ? "" : "&endTime=" + endTime;
        String stringLimit = limit == 0 || limit > 1000 ? "" : "&limit=" + limit;
        String query = symbol + stringFromId + stringStartTime + stringEndTime + stringLimit;
        String url = "https://api.binance.com/api/v1/aggTrades?" + query;
        
        return new JSONArray(httpClientResponse(url));
        
    }
    
    public JSONArray getCompressedAggregateTradesList(String symbol) throws IOException, InterruptedException {
        
        return getCompressedAggregateTradesList(symbol, 0, 0, 0, 500);
        
    }
    
    public JSONArray getKlineCandlestickData(String symbol, String interval, long startTime, long endTime, int limit) throws IOException, InterruptedException {
        symbol = symbol.equals("BTC") || symbol.equals("USDT") ? "symbol=BTCUSDT" : "symbol=" + symbol + "BTC";
        interval = "1m".equals(interval) ||
                "3m".equals(interval) ||
                "5m".equals(interval) ||
                "15m".equals(interval) ||
                "30m".equals(interval) ||
                "1h".equals(interval) ||
                "2h".equals(interval) ||
                "4h".equals(interval) ||
                "6h".equals(interval) ||
                "8h".equals(interval) ||
                "12h".equals(interval) ||
                "1d".equals(interval) ||
                "3d".equals(interval) ||
                "1w".equals(interval) ||
                "1M".equals(interval) ? "&interval=" + interval : "&interval=1d";
        String stringStartTime = startTime == 0 ? "" : "&startTime=" + startTime;
        String stringEndTime = endTime == 0 ? "" : "&endTime=" + endTime;
        String stringLimit = limit == 0 || limit > 1000 ? "" : "&limit=" + limit;
        String query = symbol + interval + stringStartTime + stringEndTime + stringLimit;
        String url = "https://api.binance.com/api/v1/klines?" + query;
        
        return new JSONArray(httpClientResponse(url));
    }
    
    public JSONArray getKlineCandlestickData(String symbol, String interval) throws IOException, InterruptedException {
        return getKlineCandlestickData(symbol, interval, 0, 0, 0);
    }
    
    
    public JSONObject getCurrentAveragePrice(String symbol) throws IOException, InterruptedException {
        
        symbol = symbol.equals("BTC") || symbol.equals("USDT") ? "symbol=BTCUSDT" : "symbol=" + symbol + "BTC";
        String query = symbol;
        String url = "https://api.binance.com/api/v3/avgPrice?" + query;
        
        return new JSONObject(httpClientResponse(url));
        
    }
    
    
    public JSONObject get24hrTickerPriceChangeStatistics(String symbol) throws IOException, InterruptedException{
        
        symbol = symbol.equals("BTC") || symbol.equals("USDT") ? "symbol=BTCUSDT" : "symbol=" + symbol + "BTC";
        String query = symbol;
        String url = "https://api.binance.com/api/v1/ticker/24hr?" + query;
        
        return new JSONObject(httpClientResponse(url));
        
    }
    
    public JSONArray get24hrTickerPriceChangeStatistics() throws IOException, InterruptedException{
        
        String url = "https://api.binance.com/api/v1/ticker/24hr";
        
        return new JSONArray(httpClientResponse(url));
        
    }
    
    
    public JSONObject getSymbolPriceTicker(String symbol) throws IOException, InterruptedException{
        
        symbol = symbol.equals("BTC") || symbol.equals("USDT") ? "symbol=BTCUSDT" : "symbol=" + symbol + "BTC";
        String query = symbol;
        String url = "https://api.binance.com/api/v3/ticker/price?" + query;
        
        return new JSONObject(httpClientResponse(url));
        
    }
    
    public JSONArray getSymbolPriceTicker() throws IOException, InterruptedException{
        
        String url = "https://api.binance.com/api/v3/ticker/price";
        
        return new JSONArray(httpClientResponse(url));
        
    }
    
    
    public JSONObject getSymbolOrderBookTicker(String symbol) throws IOException, InterruptedException {
        symbol = symbol.equals("BTC") || symbol.equals("USDT") ? "symbol=BTCUSDT" : "symbol=" + symbol + "BTC";
        String query = symbol;
        String url = "https://api.binance.com/api/v3/ticker/bookTicker?" + query;
        
        return new JSONObject(httpClientResponse(url));
    }
    
    public JSONArray getSymbolOrderBookTicker() throws IOException, InterruptedException{
        
        String url = "https://api.binance.com/api/v3/ticker/bookTicker";
        
        return new JSONArray(httpClientResponse(url));
        
    }
    
}
