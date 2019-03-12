/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ikatoo.cryptoassets.services.binance;

import io.ikatoo.cryptoassets.config.Parameters;
import io.ikatoo.cryptoassets.models.Order;
import java.math.BigDecimal;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author mckatoo
 */
public class OrdersService extends ConsumeAPI {

    private static OrdersService instance;

    private static OrdersService getInstance() {
        if (instance == null) {
            instance = new OrdersService();
        }
        return instance;
    }

    public JSONArray getAllOrders(String symbol, long orderId, long startTime, long endTime, int limit, long recvWindow) throws Exception {

        JSONArray json = null;

        symbol = symbol.equals("BTC") || symbol.equals("USDT") ? "symbol=BTCUSDT" : "symbol=" + symbol + "BTC";
        String stringOrderId = orderId == 0 ? "" : "&orderId=" + orderId;
        String stringStartTime = startTime == 0 ? "" : "&startTime=" + startTime;
        String stringEndTime = endTime == 0 ? "" : "&endTime=" + endTime;
        String stringLimit = limit == 0 || limit > 1000 ? "" : "&limit=" + limit;
        String stringRecvWindow = recvWindow == 0 || recvWindow < 10000 ? "" : "&recvWindow=" + recvWindow;
        String query = symbol + stringOrderId + stringStartTime + stringEndTime + stringLimit + stringRecvWindow + "&timestamp=" + now;

        recvWindow = recvWindow == 0 ? Parameters.getRecvWindow() : recvWindow;
        if (new RequestValidate().Validate(now, recvWindow)) {
            String signature = "signature=" + ApiSecurity.encode(_secret, query);
            String url = "https://api.binance.com/api/v3/allOrders?" + query + "&" + signature;

            json = new JSONArray(httpClientResponse(url));
        }

        return json;
    }

    public JSONArray getAllOrders(String symbol) throws Exception {
        return getAllOrders(symbol, 0, 0, 0, 0, 0);
    }

    public JSONObject getOpenOrders(String symbol, long recvWindow) throws Exception {

        JSONObject json = null;

        if (new RequestValidate().Validate(now, recvWindow)) {
            String query = "symbol=" + symbol + "&recvWindow=" + recvWindow + "&timestamp=" + now;
            String signature = "signature=" + ApiSecurity.encode(_secret, query);
            String url = "https://api.binance.com/api/v3/openOrders?" + query + "&" + signature;

            json = new JSONObject(httpClientResponse(url));
        }

        return json;
    }

    private JSONObject postNewOrder(Order order) throws Exception {

        JSONObject json = null;

        if (new RequestValidate().Validate(now, order.getRecvWindow())) {
            String symbol, side, type, timeInForce, quantity, price, stopPrice, icebergQty, newOrderRespType, recvWindow, timestamp, query, signature, url;
            symbol = order.getSymbol().equals("BTC") || order.getSymbol().equals("USDT") ? "BTCUSDT" : "symbol=" + order.getSymbol() + "BTC";
            side = "&side=" + order.getSide();
            type = "&type=" + order.getType();
            if ((order.getTimeInForce().isEmpty()) || (order.getTimeInForce().isBlank())) {
                timeInForce = "";
            } else {
                timeInForce = "&timeInForce=" + order.getTimeInForce();
            }
            quantity = "&quantity=" + order.getQuantity().toPlainString();

            if (order.getPrice().equals(BigDecimal.ZERO)) {
                price = "";
            } else {
                price = "&price=" + order.getPrice();
            }

            if (order.getStopPrice().equals(BigDecimal.ZERO)) {
                stopPrice = "";
            } else {
                stopPrice = "&stopPrice=" + order.getStopPrice();
            }

            if (order.getIcebergQty().equals(BigDecimal.ZERO)) {
                icebergQty = "";
            } else {
                icebergQty = "&icebergQty=" + order.getIcebergQty();
            }

            if (order.getNewOrderRespType() == null) {
                newOrderRespType = "";
            } else {
                newOrderRespType = "&newOrderRespType=" + order.getNewOrderRespType();
            }

            if (order.getRecvWindow() == 0) {
                recvWindow = "";
            } else {
                recvWindow = "&recvWindow=" + order.getRecvWindow();
            }

            timestamp = "&timestamp=" + now;
            
            if (new RequestValidate().Validate(now, order.getRecvWindow())) {
                query = symbol + side + type + timeInForce + quantity + price + stopPrice + icebergQty + newOrderRespType + recvWindow + timestamp;
                signature = "signature=" + ApiSecurity.encode(_secret, query);
                url = "https://api.binance.com/api/v3/order?" + query + "&" + signature;

                json = new JSONObject(httpPostResponse(url, new JSONObject(order)));
            }

//            timestamp = "&timestamp=" + now;
//            query = symbol + side + type + timeInForce + quantity + price + stopPrice + icebergQty + newOrderRespType + recvWindow + timestamp;
//            signature = "signature=" + ApiSecurity.encode(_secret, query);
//            url = "https://api.binance.com/api/v3/order/test?" + query + "&" + signature;
//
//            json = new JSONObject(httpPostResponse(url, new JSONObject(order)));
        }

        return json;

    }

    public JSONObject postNewOrderLimit(String symbol, String side, String timeInForce, BigDecimal quantity, BigDecimal price, long recvWindow) throws Exception {
        String type = "LIMIT";
        Order order = new Order(symbol, side, type, timeInForce, quantity, price, recvWindow);
        return postNewOrder(order);
    }

    public JSONObject postNewOrderMarket(String symbol, String side, BigDecimal quantity, long recvWindow) throws Exception {
        String type = "MARKET";
        Order order = new Order(symbol, side, type, quantity, recvWindow);
        return postNewOrder(order);
    }

    public JSONObject postNewOrderStopLoss(String symbol, String side, BigDecimal quantity, BigDecimal stopPrice, long recvWindow) throws Exception {
        String type = "STOP_LOSS";
        Order order = new Order(symbol, side, type, quantity, stopPrice, recvWindow);
        return postNewOrder(order);
    }

    public JSONObject postNewOrderTakeProfit(String symbol, String side, BigDecimal quantity, BigDecimal stopPrice, long recvWindow) throws Exception {
        String type = "TAKE_PROFIT";
        Order order = new Order(symbol, side, type, quantity, stopPrice, recvWindow);
        return postNewOrder(order);
    }

    public JSONObject postNewOrderStopLossLimit(String symbol, String side, String timeInForce, BigDecimal quantity, BigDecimal price, BigDecimal stopPrice, long recvWindow) throws Exception {
        String type = "STOP_LOSS_LIMIT";
        Order order = new Order(symbol, side, type, timeInForce, quantity, price, stopPrice, recvWindow);
        return postNewOrder(order);
    }

    public JSONObject postNewOrderTakeProfitLimit(String symbol, String side, String timeInForce, BigDecimal quantity, BigDecimal price, BigDecimal stopPrice, long recvWindow) throws Exception {
        String type = "TAKE_PROFIT_LIMIT";
        Order order = new Order(symbol, side, type, timeInForce, quantity, price, stopPrice, recvWindow);
        return postNewOrder(order);
    }

    public JSONObject postNewOrderLimitMaker(String symbol, String side, BigDecimal quantity, BigDecimal stopPrice, long recvWindow) throws Exception {
        String type = "LIMIT_MAKER";
        Order order = new Order(symbol, side, type, quantity, stopPrice, recvWindow);
        return postNewOrder(order);
    }

}
