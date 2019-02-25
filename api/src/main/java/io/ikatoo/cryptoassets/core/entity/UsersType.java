/**
 * @author Milton Carlos Katoo
 * @email mckatoo@gmail.com
 * @create date 2019-01-30 22:56:15
 * @modify date 2019-01-30 22:56:15
 * @desc [description]
 */

package io.ikatoo.cryptoassets.core.entity;

import javax.persistence.Entity;

import io.ikatoo.cryptoassets.core.entity.base.BaseEntity;

/**
 * UsersType
 */

@Entity
public class UsersType extends BaseEntity {
    private static final long serialVersionUID = 2016312239305958123L;
    private String type;
    private Integer level;
    private String description;

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

}