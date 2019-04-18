/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ikatoo.mavenproject2;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author mckatoo
 */
@Embeddable
public class BuyedPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @Column(name = "users_id")
    private int usersId;
    @Basic(optional = false)
    @Column(name = "assets_id")
    private int assetsId;

    public BuyedPK() {
    }

    public BuyedPK(int id, int usersId, int assetsId) {
        this.id = id;
        this.usersId = usersId;
        this.assetsId = assetsId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsersId() {
        return usersId;
    }

    public void setUsersId(int usersId) {
        this.usersId = usersId;
    }

    public int getAssetsId() {
        return assetsId;
    }

    public void setAssetsId(int assetsId) {
        this.assetsId = assetsId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) usersId;
        hash += (int) assetsId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BuyedPK)) {
            return false;
        }
        BuyedPK other = (BuyedPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.usersId != other.usersId) {
            return false;
        }
        if (this.assetsId != other.assetsId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "io.ikatoo.mavenproject2.BuyedPK[ id=" + id + ", usersId=" + usersId + ", assetsId=" + assetsId + " ]";
    }
    
}
