/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ikatoo.mavenproject2;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author mckatoo
 */
@Entity
@Table(name = "assets")
@NamedQueries({
    @NamedQuery(name = "Assets.findAll", query = "SELECT a FROM Assets a"),
    @NamedQuery(name = "Assets.findById", query = "SELECT a FROM Assets a WHERE a.id = :id"),
    @NamedQuery(name = "Assets.findByName", query = "SELECT a FROM Assets a WHERE a.name = :name"),
    @NamedQuery(name = "Assets.findBySymbol", query = "SELECT a FROM Assets a WHERE a.symbol = :symbol"),
    @NamedQuery(name = "Assets.findByImage", query = "SELECT a FROM Assets a WHERE a.image = :image"),
    @NamedQuery(name = "Assets.findByUpdatedAt", query = "SELECT a FROM Assets a WHERE a.updatedAt = :updatedAt"),
    @NamedQuery(name = "Assets.findByCreatedAt", query = "SELECT a FROM Assets a WHERE a.createdAt = :createdAt")})
public class Assets implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "symbol")
    private String symbol;
    @Basic(optional = false)
    @Column(name = "image")
    private String image;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @JoinTable(name = "exchanges_has_assets", joinColumns = {
        @JoinColumn(name = "assets_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "exchanges_id", referencedColumnName = "id")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Exchanges> exchangesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "assets", fetch = FetchType.LAZY)
    private Collection<Buyed> buyedCollection;

    public Assets() {
    }

    public Assets(Integer id) {
        this.id = id;
    }

    public Assets(Integer id, String name, String symbol, String image) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public Collection<Exchanges> getExchangesCollection() {
        return exchangesCollection;
    }

    public void setExchangesCollection(Collection<Exchanges> exchangesCollection) {
        this.exchangesCollection = exchangesCollection;
    }

    public Collection<Buyed> getBuyedCollection() {
        return buyedCollection;
    }

    public void setBuyedCollection(Collection<Buyed> buyedCollection) {
        this.buyedCollection = buyedCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Assets)) {
            return false;
        }
        Assets other = (Assets) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "io.ikatoo.mavenproject2.Assets[ id=" + id + " ]";
    }
    
}
