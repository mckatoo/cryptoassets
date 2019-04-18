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
public class UsersPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @Column(name = "users_type_id")
    private int usersTypeId;

    public UsersPK() {
    }

    public UsersPK(int id, int usersTypeId) {
        this.id = id;
        this.usersTypeId = usersTypeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsersTypeId() {
        return usersTypeId;
    }

    public void setUsersTypeId(int usersTypeId) {
        this.usersTypeId = usersTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) usersTypeId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsersPK)) {
            return false;
        }
        UsersPK other = (UsersPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.usersTypeId != other.usersTypeId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "io.ikatoo.mavenproject2.UsersPK[ id=" + id + ", usersTypeId=" + usersTypeId + " ]";
    }
    
}
