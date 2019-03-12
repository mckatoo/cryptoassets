/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ikatoo.cryptoassets.models;

import io.ikatoo.cryptoassets.config.Parameters;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 *
 * @author mckatoo
 */
public class Order {

    String Symbol;
    String Side;
    String Type;                // LIMIT, MARKET, STOP_LOSS, STOP_LOSS_LIMIT, TAKE_PROFIT, TAKE_PROFIT_LIMIT, LIMIT_MAKER
    String TimeInForce;         //Mandatory for types = LIMIT, STOP_LOSS_LIMIT, TAKE_PROFIT_LIMIT
    BigDecimal Quantity;
    BigDecimal Price;           //Mandatory for types = LIMIT, STOP_LOSS_LIMIT, TAKE_PROFIT_LIMIT, LIMIT_MAKER
    BigDecimal StopPrice;       //Mantory for types = STOP_LOSS, STOP_LOSS_LIMIT, TAKE_PROFIT, TAKE_PROFIT_LIMIT
    BigDecimal IcebergQty;      // Used with LIMIT, STOP_LOSS_LIMIT, and TAKE_PROFIT_LIMIT to create an iceberg order.
    String NewOrderRespType;	//Set the response JSON. ACK, RESULT, or FULL; MARKET and LIMIT order types default to FULL, all other orders default to ACK.
    long recvWindow;
    long timestamp;

    // LIMIT
    public Order(String Symbol, String Side, String Type, String TimeInForce, BigDecimal Quantity, BigDecimal Price, long recvWindow) {
        this.Symbol = Symbol;
        this.Side = Side;
        this.Type = Type;
        this.TimeInForce = TimeInForce;
        this.Quantity = Quantity;
        this.Price = Price;
        this.timestamp = new Timestamp(System.currentTimeMillis()).getTime();
    }

    // MARKET
    public Order(String Symbol, String Side, String Type, BigDecimal Quantity, long recvWindow) {
        this.Symbol = Symbol;
        this.Side = Side;
        this.Type = Type;
        this.Quantity = Quantity;
        this.timestamp = new Timestamp(System.currentTimeMillis()).getTime();
    }

    // STOP_LOSS & TAKE_PROFIT || LIMIT_MAKER
    public Order(String Symbol, String Side, String Type, BigDecimal Quantity, BigDecimal PriceOrStopPrice, long recvWindow) {
        this.Symbol = Symbol;
        this.Side = Side;
        this.Type = Type;
        this.Quantity = Quantity;
        if ((Type.equals("STOP_LOSS")) || (Type.equals("TAKE_PROFIT"))) {
            this.Price = PriceOrStopPrice;
        } else {
            this.StopPrice = PriceOrStopPrice;
        }
        this.timestamp = new Timestamp(System.currentTimeMillis()).getTime();
    }

    //STOP_LOSS_LIMIT & TAKE_PROFIT_LIMIT
    public Order(String Symbol, String Side, String Type, String TimeInForce, BigDecimal Quantity, BigDecimal Price, BigDecimal StopPrice, long recvWindow) {
        this.Symbol = Symbol;
        this.Side = Side;
        this.Type = Type;
        this.TimeInForce = TimeInForce;
        this.Quantity = Quantity;
        this.Price = Price;
        this.StopPrice = StopPrice;
        this.timestamp = new Timestamp(System.currentTimeMillis()).getTime();
    }

    public String getSymbol() {
        return Symbol;
    }

    public String getSide() {
        return Side;
    }

    public String getType() {
        return Type;
    }

    public String getTimeInForce() {
        return TimeInForce;
    }

    public BigDecimal getQuantity() {
        if (Quantity == null) {
            return BigDecimal.ZERO;
        }
        return Quantity;
    }

    public BigDecimal getPrice() {
        if (Price == null) {
            return BigDecimal.ZERO;
        }
        return Price;
    }

    public BigDecimal getStopPrice() {
        if (StopPrice == null) {
            return BigDecimal.ZERO;
        }
        return StopPrice;
    }

    public BigDecimal getIcebergQty() {
        if (IcebergQty == null) {
            return BigDecimal.ZERO;
        }
        return IcebergQty;
    }

    public String getNewOrderRespType() {
        return NewOrderRespType;
    }

    public long getRecvWindow() throws IOException {
        long _recvWindow = Parameters.getRecvWindow();
        if (this.recvWindow < _recvWindow) {
            return _recvWindow;
        }
        return this.recvWindow;
    }

    public long getTimestamp() {
        return timestamp;
    }

}
