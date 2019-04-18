package io.ikatoo.cryptoassets.core.entity;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import io.ikatoo.cryptoassets.core.entity.base.BaseEntity;

/**
 * Buyed
 */
@Entity
public class Buyed extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Column(precision = 9, scale = 8)
    @NotNull
    private BigDecimal amount;
    @Column(precision = 9, scale = 8)
    @NotNull
    private BigDecimal cost;
    @Column(precision = 9, scale = 8)
    @NotNull
    private BigDecimal buy;
    @Column(precision = 9, scale = 8)
    private BigDecimal sell;
    @Column(precision = 9, scale = 8)
    private BigDecimal profit;
    @Column(precision = 9, scale = 8)
    private BigDecimal takeProfit;
    @Column(precision = 9, scale = 8)
    private BigDecimal stop;
    @NotNull
    private OffsetDateTime open;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "usersId", nullable = false)
    @NotNull
    private Users users;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "assetsId", nullable = false)
    @NotNull
    private Assets assets;

    public BigDecimal getAmount() {
        return this.amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getCost() {
        return this.cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getBuy() {
        return this.buy;
    }

    public void setBuy(BigDecimal buy) {
        this.buy = buy;
    }

    public BigDecimal getSell() {
        return this.sell;
    }

    public void setSell(BigDecimal sell) {
        this.sell = sell;
    }

    public BigDecimal getProfit() {
        return this.profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public BigDecimal getTakeProfit() {
        return this.takeProfit;
    }

    public void setTakeProfit(BigDecimal takeProfit) {
        this.takeProfit = takeProfit;
    }

    public BigDecimal getStop() {
        return this.stop;
    }

    public void setStop(BigDecimal stop) {
        this.stop = stop;
    }

    public OffsetDateTime getOpen() {
        return this.open;
    }

    public void setOpen(OffsetDateTime open) {
        this.open = open;
    }

    public Users getUsers() {
        return this.users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Assets getAssets() {
        return this.assets;
    }

    public void setAssets(Assets assets) {
        this.assets = assets;
    }

}