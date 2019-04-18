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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Table(name = "exchanges")
@NamedQueries({
    @NamedQuery(name = "Exchanges.findAll", query = "SELECT e FROM Exchanges e"),
    @NamedQuery(name = "Exchanges.findById", query = "SELECT e FROM Exchanges e WHERE e.id = :id"),
    @NamedQuery(name = "Exchanges.findByExchange", query = "SELECT e FROM Exchanges e WHERE e.exchange = :exchange"),
    @NamedQuery(name = "Exchanges.findByApiKey", query = "SELECT e FROM Exchanges e WHERE e.apiKey = :apiKey"),
    @NamedQuery(name = "Exchanges.findByApiSecret", query = "SELECT e FROM Exchanges e WHERE e.apiSecret = :apiSecret"),
    @NamedQuery(name = "Exchanges.findByUpdatedAt", query = "SELECT e FROM Exchanges e WHERE e.updatedAt = :updatedAt"),
    @NamedQuery(name = "Exchanges.findByCreatedAt", query = "SELECT e FROM Exchanges e WHERE e.createdAt = :createdAt")})
public class Exchanges implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "exchange")
    private String exchange;
    @Basic(optional = false)
    @Column(name = "api_key")
    private String apiKey;
    @Basic(optional = false)
    @Column(name = "api_secret")
    private String apiSecret;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @ManyToMany(mappedBy = "exchangesCollection", fetch = FetchType.LAZY)
    private Collection<Assets> assetsCollection;

    public Exchanges() {
    }

    public Exchanges(Integer id) {
        this.id = id;
    }

    public Exchanges(Integer id, String exchange, String apiKey, String apiSecret) {
        this.id = id;
        this.exchange = exchange;
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiSecret() {
        return apiSecret;
    }

    public void setApiSecret(String apiSecret) {
        this.apiSecret = apiSecret;
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

    public Collection<Assets> getAssetsCollection() {
        return assetsCollection;
    }

    public void setAssetsCollection(Collection<Assets> assetsCollection) {
        this.assetsCollection = assetsCollection;
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
        if (!(object instanceof Exchanges)) {
            return false;
        }
        Exchanges other = (Exchanges) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "io.ikatoo.mavenproject2.Exchanges[ id=" + id + " ]";
    }
    
}
