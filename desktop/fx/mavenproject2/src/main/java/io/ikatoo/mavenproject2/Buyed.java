/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ikatoo.mavenproject2;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author mckatoo
 */
@Entity
@Table(name = "buyed")
@NamedQueries({
    @NamedQuery(name = "Buyed.findAll", query = "SELECT b FROM Buyed b"),
    @NamedQuery(name = "Buyed.findById", query = "SELECT b FROM Buyed b WHERE b.buyedPK.id = :id"),
    @NamedQuery(name = "Buyed.findByAmount", query = "SELECT b FROM Buyed b WHERE b.amount = :amount"),
    @NamedQuery(name = "Buyed.findByCost", query = "SELECT b FROM Buyed b WHERE b.cost = :cost"),
    @NamedQuery(name = "Buyed.findByBuy", query = "SELECT b FROM Buyed b WHERE b.buy = :buy"),
    @NamedQuery(name = "Buyed.findBySell", query = "SELECT b FROM Buyed b WHERE b.sell = :sell"),
    @NamedQuery(name = "Buyed.findByProfit", query = "SELECT b FROM Buyed b WHERE b.profit = :profit"),
    @NamedQuery(name = "Buyed.findByTakeProfit", query = "SELECT b FROM Buyed b WHERE b.takeProfit = :takeProfit"),
    @NamedQuery(name = "Buyed.findByStop", query = "SELECT b FROM Buyed b WHERE b.stop = :stop"),
    @NamedQuery(name = "Buyed.findByUsersId", query = "SELECT b FROM Buyed b WHERE b.buyedPK.usersId = :usersId"),
    @NamedQuery(name = "Buyed.findByOpen", query = "SELECT b FROM Buyed b WHERE b.open = :open"),
    @NamedQuery(name = "Buyed.findByAssetsId", query = "SELECT b FROM Buyed b WHERE b.buyedPK.assetsId = :assetsId"),
    @NamedQuery(name = "Buyed.findByUpdatedAt", query = "SELECT b FROM Buyed b WHERE b.updatedAt = :updatedAt"),
    @NamedQuery(name = "Buyed.findByCreatedAt", query = "SELECT b FROM Buyed b WHERE b.createdAt = :createdAt")})
public class Buyed implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BuyedPK buyedPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "amount")
    private BigDecimal amount;
    @Basic(optional = false)
    @Column(name = "cost")
    private BigDecimal cost;
    @Basic(optional = false)
    @Column(name = "buy")
    private BigDecimal buy;
    @Column(name = "sell")
    private BigDecimal sell;
    @Column(name = "profit")
    private BigDecimal profit;
    @Column(name = "take_profit")
    private BigDecimal takeProfit;
    @Column(name = "stop")
    private BigDecimal stop;
    @Basic(optional = false)
    @Column(name = "open")
    @Temporal(TemporalType.TIMESTAMP)
    private Date open;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @JoinColumn(name = "assets_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Assets assets;
    @JoinColumn(name = "users_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Users users;

    public Buyed() {
    }

    public Buyed(BuyedPK buyedPK) {
        this.buyedPK = buyedPK;
    }

    public Buyed(BuyedPK buyedPK, BigDecimal amount, BigDecimal cost, BigDecimal buy, Date open) {
        this.buyedPK = buyedPK;
        this.amount = amount;
        this.cost = cost;
        this.buy = buy;
        this.open = open;
    }

    public Buyed(int id, int usersId, int assetsId) {
        this.buyedPK = new BuyedPK(id, usersId, assetsId);
    }

    public BuyedPK getBuyedPK() {
        return buyedPK;
    }

    public void setBuyedPK(BuyedPK buyedPK) {
        this.buyedPK = buyedPK;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getBuy() {
        return buy;
    }

    public void setBuy(BigDecimal buy) {
        this.buy = buy;
    }

    public BigDecimal getSell() {
        return sell;
    }

    public void setSell(BigDecimal sell) {
        this.sell = sell;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public BigDecimal getTakeProfit() {
        return takeProfit;
    }

    public void setTakeProfit(BigDecimal takeProfit) {
        this.takeProfit = takeProfit;
    }

    public BigDecimal getStop() {
        return stop;
    }

    public void setStop(BigDecimal stop) {
        this.stop = stop;
    }

    public Date getOpen() {
        return open;
    }

    public void setOpen(Date open) {
        this.open = open;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Assets getAssets() {
        return assets;
    }

    public void setAssets(Assets assets) {
        this.assets = assets;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (buyedPK != null ? buyedPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Buyed)) {
            return false;
        }
        Buyed other = (Buyed) object;
        if ((this.buyedPK == null && other.buyedPK != null) || (this.buyedPK != null && !this.buyedPK.equals(other.buyedPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "io.ikatoo.mavenproject2.Buyed[ buyedPK=" + buyedPK + " ]";
    }
    
}
