/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ikatoo.mavenproject2;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author mckatoo
 */
@Entity
@Table(name = "users_type")
@NamedQueries({
    @NamedQuery(name = "UsersType.findAll", query = "SELECT u FROM UsersType u"),
    @NamedQuery(name = "UsersType.findById", query = "SELECT u FROM UsersType u WHERE u.id = :id"),
    @NamedQuery(name = "UsersType.findByType", query = "SELECT u FROM UsersType u WHERE u.type = :type"),
    @NamedQuery(name = "UsersType.findByLevel", query = "SELECT u FROM UsersType u WHERE u.level = :level"),
    @NamedQuery(name = "UsersType.findByDescription", query = "SELECT u FROM UsersType u WHERE u.description = :description"),
    @NamedQuery(name = "UsersType.findByCreatedAt", query = "SELECT u FROM UsersType u WHERE u.createdAt = :createdAt"),
    @NamedQuery(name = "UsersType.findByUpdatedAt", query = "SELECT u FROM UsersType u WHERE u.updatedAt = :updatedAt")})
public class UsersType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @Column(name = "level")
    private int level;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usersType", fetch = FetchType.LAZY)
    private Users users;

    public UsersType() {
    }

    public UsersType(Integer id) {
        this.id = id;
    }

    public UsersType(Integer id, String type, int level, String description) {
        this.id = id;
        this.type = type;
        this.level = level;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsersType)) {
            return false;
        }
        UsersType other = (UsersType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "io.ikatoo.mavenproject2.UsersType[ id=" + id + " ]";
    }
    
}
