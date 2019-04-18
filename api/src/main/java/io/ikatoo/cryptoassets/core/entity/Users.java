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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.ikatoo.cryptoassets.core.entity.base.BaseEntity;

/**
 * Users
 */

@Entity
public class Users extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @NotNull
    private String name;
    @Email
    @NotNull
    @Column(unique = true)
    private String email;
    @NotNull
    @Column(unique = true)
    private String username;
    @NotNull
    @JsonIgnore
    private String password;
    private String rememberToken;

    @JsonBackReference
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "users_has_types", joinColumns = @JoinColumn(name = "users_id", nullable = false), inverseJoinColumns = @JoinColumn(name = "users_types_id", nullable = false))
    @NotNull
    private List<UsersTypes> types = new ArrayList<>();

    public Users() {
    }

    public Users(String name, String email, String username, String password, String rememberToken) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.rememberToken = rememberToken;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRememberToken() {
        return this.rememberToken;
    }

    public void setRememberToken(String rememberToken) {
        this.rememberToken = rememberToken;
    }

    public List<UsersTypes> getTypes() {
        return this.types;
    }

    public void setTypes(List<UsersTypes> types) {
        this.types = types;
    }

}