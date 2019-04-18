package io.ikatoo.cryptoassets.core.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import io.ikatoo.cryptoassets.core.entity.base.BaseEntity;

/**
 * Assets
 */
@Entity
public class Assets extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @NotNull
    private String name;
    @NotNull
    private String symbol;
    @NotNull
    private String image;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "exchanges_has_assets", joinColumns = @JoinColumn(name = "assets_id", nullable = false), inverseJoinColumns = @JoinColumn(name = "exchanges_id", nullable = false))
    @NotNull
    private List<Exchanges> exchanges = new ArrayList<Exchanges>();

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Exchanges> getExchanges() {
        return this.exchanges;
    }

    public void setExchanges(List<Exchanges> exchanges) {
        this.exchanges = exchanges;
    }

}