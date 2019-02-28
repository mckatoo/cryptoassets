/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ikatoo.cryptoassets.models;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author mckatoo
 */
public class Portifolio {
    private ImageIcon Icon;
    private String Asset;
    private BigDecimal Buy;
    private Date DateBuy;
    private BigDecimal Sell;
    private Date DateSell;
    private BigDecimal Current;
    private BigDecimal Profit;
    private BigDecimal Free;
    private BigDecimal InOrder;
    private BigDecimal TotalBalance;

    public Portifolio(ImageIcon Icon, String Asset, BigDecimal Buy, Date DateBuy, BigDecimal Sell, Date DateSell, BigDecimal Current, BigDecimal Profit, BigDecimal Free, BigDecimal InOrder, BigDecimal TotalBalance) {
        this.Icon = Icon;
        this.Asset = Asset;
        this.Buy = Buy;
        this.DateBuy = DateBuy;
        this.Sell = Sell;
        this.DateSell = DateSell;
        this.Current = Current;
        this.Profit = Profit;
        this.Free = Free;
        this.InOrder = InOrder;
        this.TotalBalance = TotalBalance;
    }

    public ImageIcon getIcon() {
        return Icon;
    }

    public void setIcon(ImageIcon Icon) {
        this.Icon = Icon;
    }

    public String getAsset() {
        return Asset;
    }

    public void setAsset(String Asset) {
        this.Asset = Asset;
    }

    public BigDecimal getBuy() {
        return Buy;
    }

    public void setBuy(BigDecimal Buy) {
        this.Buy = Buy;
    }

    public Date getDateBuy() {
        return DateBuy;
    }

    public void setDateBuy(Date DateBuy) {
        this.DateBuy = DateBuy;
    }

    public BigDecimal getSell() {
        return Sell;
    }

    public void setSell(BigDecimal Sell) {
        this.Sell = Sell;
    }

    public Date getDateSell() {
        return DateSell;
    }

    public void setDateSell(Date DateSell) {
        this.DateSell = DateSell;
    }

    public BigDecimal getCurrent() {
        return Current;
    }

    public void setCurrent(BigDecimal Current) {
        this.Current = Current;
    }

    public BigDecimal getProfit() {
        return Profit;
    }

    public void setProfit(BigDecimal Profit) {
        this.Profit = Profit;
    }

    public BigDecimal getFree() {
        return Free;
    }

    public void setFree(BigDecimal Free) {
        this.Free = Free;
    }

    public BigDecimal getInOrder() {
        return InOrder;
    }

    public void setInOrder(BigDecimal InOrder) {
        this.InOrder = InOrder;
    }

    public BigDecimal getTotalBalance() {
        return TotalBalance;
    }

    public void setTotalBalance(BigDecimal TotalBalance) {
        this.TotalBalance = TotalBalance;
    }
    
    

}
