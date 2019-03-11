/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ikatoo.cryptoassets.models;

import java.math.BigDecimal;

/**
 *
 * @author mckatoo
 */
public class Order {
    String Symbol;
    String Side;
    String Type; // LIMIT, MARKET, STOP_LOSS, STOP_LOSS_LIMIT, TAKE_PROFIT, TAKE_PROFIT_LIMIT, LIMIT_MAKER
    String TimeInForce; //Mandatory for type = LIMIT, STOP_LOSS_LIMIT, TAKE_PROFIT_LIMIT
    BigDecimal Quantity; //Mandatory for all types
    BigDecimal Price;
//    String NewClientOrderId;
    BigDecimal StopPrice;
    BigDecimal IcebergQty;
    String NewOrderRespType;	//Set the response JSON. ACK, RESULT, or FULL; MARKET and LIMIT order types default to FULL, all other orders default to ACK.
    long recvWindow;
    long timestamp;
}
