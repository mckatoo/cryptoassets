/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ikatoo.cryptoassets.interfaces.chart.candlestick.model;

/**
 *
 * @author mckatoo
 */
public class Trade {

    private final long time;
    private final double price;
    private final double size;

    public Trade(long time, double price, double size) {
        super();
        this.time = time;
        this.price = price;
        this.size = size;
    }

    public long getTime() {
        return time;
    }

    public double getPrice() {
        return price;
    }

    public double getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Trade [time=" + time + ", price=" + price + ", size=" + size + "]";
    }

}
