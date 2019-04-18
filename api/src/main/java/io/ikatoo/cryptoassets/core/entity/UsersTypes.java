/**
 * @author Milton Carlos Katoo
 * @email mckatoo@gmail.com
 * @create date 2019-01-30 22:56:15
 * @modify date 2019-01-30 22:56:15
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

import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.ikatoo.cryptoassets.core.entity.base.BaseEntity;

/**
 * UsersType
 */

@Entity
public class UsersTypes extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @NotNull
    private String type;
    @NotNull
    private Integer level;
    private String description;

    @JsonManagedReference
    @ManyToMany(mappedBy = "types", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @NotNull
    private List<Users> users = new ArrayList<>();

    public UsersTypes() {
    }

    public UsersTypes(String type, Integer level, String description) {
        this.type = type;
        this.level = level;
        this.description = description;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getLevel() {
        return this.level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Users> getUsers() {
        return this.users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

}