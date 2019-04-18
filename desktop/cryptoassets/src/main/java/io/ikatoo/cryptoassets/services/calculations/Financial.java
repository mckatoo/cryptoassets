/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ikatoo.cryptoassets.services.calculations;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author mckatoo
 */
public class Financial {
    public static BigDecimal calcProfit(BigDecimal sell, BigDecimal buy){
        return sell.subtract(buy);
    }
    
    public static BigDecimal calcProfitPercent(BigDecimal sell, BigDecimal buy){
        BigDecimal profit = calcProfit(sell, buy);
        BigDecimal profitPercent = profit.divide(buy, 8, RoundingMode.HALF_EVEN).multiply(new BigDecimal("100"));
        return profitPercent;
    }
}
