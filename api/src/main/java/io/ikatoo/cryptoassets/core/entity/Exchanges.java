/**
 * @author Milton Carlos Katoo
 * @email mckatoo@gmail.com
 * @create date 2019-01-30 17:50:25
 * @modify date 2019-01-30 17:50:25
 * @desc [description]
 */

package io.ikatoo.cryptoassets.core.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.ikatoo.cryptoassets.core.entity.base.BaseEntity;

/**
 * Exchanges
 */

@Entity
public class Exchanges extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private String exchange;
    @NotNull
    @JsonIgnore
    private String apiKey;
    @NotNull
    @JsonIgnore
    private String apiSecret;

    @ManyToMany(mappedBy = "exchanges", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @NotNull
    private List<Assets> assets = new ArrayList<Assets>();

    public String getExchange() {
        return this.exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getApiKey() {
        return this.apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiSecret() {
        return this.apiSecret;
    }

    public void setApiSecret(String apiSecret) {
        this.apiSecret = apiSecret;
    }

    public List<Assets> getAssets() {
        return this.assets;
    }

    public void setAssets(List<Assets> assets) {
        this.assets = assets;
    }

}