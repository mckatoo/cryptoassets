/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ikatoo.cryptoassets.services.calculations;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author mckatoo
 */
public class Price {

    public static JSONObject averagePrice(JSONArray jsonArray, BigDecimal maxValue) {

        maxValue.setScale(8, RoundingMode.HALF_EVEN);
        BigDecimal zero = BigDecimal.ZERO;
        BigDecimal average = zero;
        BigDecimal sumCost = zero;
        BigDecimal sumAsset = zero;
        long dateBuy = 0;
        JSONObject price = new JSONObject();
        int jsonSize = jsonArray.length() - 1;
        int countOrders = 0;
        BigDecimal valueLastBuy = zero;

        for (int j = jsonSize; ((maxValue).compareTo(sumAsset) == 1) && (j > -1); j--) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(j);
            BigDecimal cost = jsonObject.getBigDecimal("price");
            BigDecimal executedQty = jsonObject.getBigDecimal("executedQty");
            if ((jsonObject.get("side").toString().equals("BUY")) && (executedQty.compareTo(zero) == 1)) {
                countOrders += 1;
                if (countOrders == 1) {
                    valueLastBuy = cost;
                }
                sumCost = sumCost.add(cost.multiply(executedQty));
                sumAsset = sumAsset.add(executedQty);
                dateBuy = jsonObject.getLong("time");
            }
        }

        if (countOrders == 1) {
            average = valueLastBuy;
        } else {
            average = sumCost.divide(sumAsset, 8, RoundingMode.HALF_EVEN);
        }

        price.put("price", average);
        price.put("dateBuy", dateBuy);

        return price;
    }

}
