/**
 * @author Milton Carlos Katoo
 * @email mckatoo@gmail.com
 * @create date 2019-01-30 17:50:25
 * @modify date 2019-01-30 17:50:25
 * @desc [description]
 */

package io.ikatoo.cryptoassets.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.ikatoo.cryptoassets.core.entity.base.BaseEntity;

/**
 * Users
 */

@Entity
public class Users extends BaseEntity {

    private static final long serialVersionUID = -26963215018239031L;
    private String name;
    @Email
    @NotEmpty
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String username;
    @NotEmpty
    @JsonIgnore
    private String password;
    private String rememberToken;
    @ManyToOne
    @JoinColumn(name = "usersTypeId")
    @NotNull
    private UsersType usersType;

    public String getName() {
        return this.name;
    }

    /**
     * @return the usersType
     */
    public UsersType getUsersType() {
        return usersType;
    }

    /**
     * @param usersType the usersType to set
     */
    public void setUsersType(UsersType usersType) {
        this.usersType = usersType;
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

}